package com.user.manager.repository;

import com.user.manager.model.Permission;
import com.user.manager.model.Role;
import com.user.manager.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DbInit implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PermissionRepository permissionRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
//        this.userRepository.deleteAll();
//        this.roleRepository.deleteAll();
//        this.permissionRepository.deleteAll();

        //INITIALIZATION
        Permission p1=new Permission();
        Permission p2=new Permission();
        Permission p3=new Permission();

        Role role1=new Role();
        Role role2=new Role();

        //TEST PERMISSION
        p1.setName("TEST");
        permissionRepository.save(p1);
        p2.setName("ADMIN");
        permissionRepository.save(p2);
        p3.setName("USER");
        permissionRepository.save(p3);

        List<Permission> adminList=new ArrayList<Permission>();
        adminList.add(p1);
        adminList.add(p2);

        List<Permission> userList=new ArrayList<Permission>();
        userList.add(p3);

        //USER_ROLE
        role2.setName("ADMIN");
        role2.setPermissions(adminList);
        roleRepository.save(role2);

        role1.setName("USER");
        role1.setPermissions(userList);
        roleRepository.save(role1);

        List<Role> roleList=new ArrayList<Role>();
        roleList.add(role1);
        List<Role> roleList2=new ArrayList<Role>();
        roleList.add(role2);

        //USERS
        User user1= new User();
        User user2= new User();
        user1.setEmail("marko@com");
        user1.setUsername("admin");
        user1.setPassword(passwordEncoder.encode("admin123"));
        user1.setRoles(roleList);

        user2.setEmail("bla@com");
        user2.setUsername("user");
        user2.setPassword(passwordEncoder.encode("user123"));
        user2.setRoles(roleList2);

        userRepository.save(user1);
        userRepository.save(user2);
    }
}
