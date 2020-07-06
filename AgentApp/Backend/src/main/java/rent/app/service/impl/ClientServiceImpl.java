package rent.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rent.app.model.Client;
import rent.app.model.RegistrationRequest;
import rent.app.model.security.Permission;
import rent.app.model.security.Role;
import rent.app.repository.ClientRepository;
import rent.app.repository.PermissionRepository;
import rent.app.repository.RoleRepository;
import rent.app.service.ClientService;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void createClientFromRegistration(RegistrationRequest rq) {

        Client client = new Client();
        client.setEmail(rq.getEmail());
        client.setUsername(rq.getUsername());
        client.setName(rq.getName());
        client.setSurname(rq.getSurname());
        client.setPassword(passwordEncoder.encode(rq.getPassword()));

        //da se sacuvaju permisije i role za kreiranu osobu :)
        Permission p = new Permission();
        Role role = new Role();
        if (permissionRepository.findByName(rq.getRole()) == null) {

            p.setName(rq.getRole());
            permissionRepository.save(p);
        }
        else {
            p = permissionRepository.findByName(rq.getRole());
        }

        if(roleRepository.findByName(rq.getRole())==null) {

            ArrayList<Permission> list = new ArrayList<Permission> ();
            list.add(p);
            role.setName(rq.getRole());
            role.setPermissions(list);
            roleRepository.save(role);
        }
        else {
            role = roleRepository.findByName(rq.getRole());

            if(role.getPermissions().contains(p)==false) {
                role.getPermissions().add(p);
            }
        }

        ArrayList<Role> roleList = new ArrayList<Role> ();
        roleList.add(role);
        client.setRoles(roleList);

        //ovde sad dodati role -u nekako :)


        clientRepository.save(client);
    }
}
