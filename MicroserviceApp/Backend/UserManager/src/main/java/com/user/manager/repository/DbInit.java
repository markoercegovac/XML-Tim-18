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

        //INITIALIZATION
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
        User user1= new User();
        User user2= new User();
        User user3= new User();
        user1.setEmail("marko@com");
        user1.setUsername("marko");
        user1.setPassword(passwordEncoder.encode("admin123"));
        user1.setRoles(roleList2);

        //PERA USER
        user2.setEmail("pera@com");
        user2.setUsername("pera");
        user2.setPassword(passwordEncoder.encode("user123"));
        user2.setRoles(roleList3);

        //ZIKA VLASNIK
        user3.setEmail("zika@com");
        user3.setUsername("zika");
        user3.setPassword(passwordEncoder.encode("user123"));
        user3.setRoles(roleList1);

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
    }
}
