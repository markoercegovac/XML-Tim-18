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
//        Permission p1=new Permission();
//        Permission p2=new Permission();
//        Permission p3=new Permission();
//
//        Role role1=new Role();
//        Role role2=new Role();
//
//        //TEST PERMISSION
//        p1.setName("ADMIN");
//        permissionRepository.save(p1);
//
//        List<Permission> testList=new ArrayList<Permission>();
//        testList.add(p1);
//
//        //USER_ROLE
//        role1.setName("USER");
//        role1.setPermissions(testList);
//        roleRepository.save(role1);
//
//        List<Role> roleList=new ArrayList<Role>();
//        roleList.add(role1);
//
//        //USERS
//        Client user1= new Client();
//        Client user2= new Client();
//        Client user3= new Client();
//        user1.setEmail("marko@com");
//        user1.setUsername("marko@com");
//        user1.setPassword(passwordEncoder.encode("admin123"));
//        user1.setRoles(roleList);
//
//        user2.setEmail("bla@com");
//        user2.setUsername("bla@com");
//        user2.setPassword(passwordEncoder.encode("user123"));
//
//        userRepository.save(user1);
//        userRepository.save(user2);



        Permission p1=new Permission();
        Permission p2=new Permission();
        Permission p3=new Permission();

        p1.setName("OWNER");
        permissionRepository.save(p1);
        p2.setName("ADMIN");
        permissionRepository.save(p2);
        p3.setName("USER");
        permissionRepository.save(p3);

        List<Permission> ownerList=new ArrayList<Permission>();
        ownerList.add(p1);
        List<Permission> adminList=new ArrayList<Permission>();
        adminList.add(p2);
        List<Permission> userList=new ArrayList<Permission>();
        userList.add(p3);

        //USER_ROLE
        Role role1=new Role();
        Role role2=new Role();
        Role role3=new Role();
        Role role4=new Role();

        role1.setName("OWNER");
        role1.setPermissions(ownerList);
        roleRepository.save(role1);

        role2.setName("ADMIN");
        role2.setPermissions(adminList);
        roleRepository.save(role2);

        role3.setName("USER");
        role3.setPermissions(userList);
        roleRepository.save(role3);

        List<Role> roleList1=new ArrayList<Role>();
        roleList1.add(role1);
        List<Role> roleList2=new ArrayList<Role>();
        roleList2.add(role2);
        List<Role> roleList3=new ArrayList<Role>();
        roleList3.add(role3);

        //USERS
        Client user1= new Client();
        Client user2= new Client();
        Client user3= new Client();
        user1.setEmail("marko@com");
        user1.setUsername("marko@com");
        user1.setPassword(passwordEncoder.encode("admin123"));
        user1.setRoles(roleList2);

        user2.setEmail("bla@com");
        user2.setUsername("bla@com");
        user2.setPassword(passwordEncoder.encode("user123"));
        user2.setRoles(roleList3);

        user3.setEmail("firm@com");
        user3.setUsername("firm@com");
        user3.setPassword(passwordEncoder.encode("firm123"));
        user3.setRoles(roleList1);
        user3.setCity("Sabac");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

    }
}
