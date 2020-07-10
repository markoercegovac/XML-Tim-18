package rent.app.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rent.app.model.Client;
import rent.app.model.security.Permission;
import rent.app.model.security.Role;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
class DbInit implements CommandLineRunner {

    private final ClientRepository userRepository;
    private final PermissionRepository permissionRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        this.userRepository.deleteAll();
        this.roleRepository.deleteAll();
        this.permissionRepository.deleteAll();

        //INITIALIZATION
        Permission p1=new Permission();
        Permission p2=new Permission();
        Permission p3=new Permission();

        Role role1=new Role();
        Role role2=new Role();

        //TEST PERMISSION
        p1.setName("ADMIN");
        permissionRepository.save(p1);

        List<Permission> testList=new ArrayList<Permission>();
        testList.add(p1);

        //USER_ROLE
        role1.setName("USER");
        role1.setPermissions(testList);
        roleRepository.save(role1);

        List<Role> roleList=new ArrayList<Role>();
        roleList.add(role1);

        //USERS
        Client user1= new Client();
        Client user2= new Client();
        user1.setEmail("marko@com");
        user1.setUsername("marko@com");
        user1.setPassword(passwordEncoder.encode("admin123"));
        user1.setRoles(roleList);

        user2.setEmail("bla@com");
        user2.setUsername("bla@com");
        user2.setPassword(passwordEncoder.encode("user123"));
        user2.setCity("Sabac");

        userRepository.save(user1);
        userRepository.save(user2);








    }
}
