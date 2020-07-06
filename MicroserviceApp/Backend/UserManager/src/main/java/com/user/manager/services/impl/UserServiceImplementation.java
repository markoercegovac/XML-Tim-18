package com.user.manager.services.impl;


import com.user.manager.dto.UserDto;
import com.user.manager.model.Permission;
import com.user.manager.model.Role;
import com.user.manager.model.User;
import com.user.manager.repository.PermissionRepository;
import com.user.manager.repository.RoleRepository;
import com.user.manager.repository.UserRepository;
import com.user.manager.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    @Override
    public List<UserDto> allUsers() {
        return null;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public User getUser(String email) {
        return userRepository.findByUsername(email);
    }

    @Override
    public void addAdminRole(User user) {
        User temp = userRepository.findByUsername(user.getEmail());
        ArrayList<Role> roles = new ArrayList<Role>( temp.getRoles());
        ArrayList<Permission> permissions = new ArrayList<Permission>();
        Role r = roleRepository.findByName("ADMIN");
        Permission p = permissionRepository.findByName("ADMIN");

        if(p==null) { p = new Permission(); p.setName("ADMIN");
        if(r==null) {
            r = new Role(); r.setName("ADMIN");
            permissions.add(p);
            r.setPermissions(permissions);
        }
        boolean found = false;
        for(Role role : roles) {
            if(role.getName().equals("ADMIN")) {
                found=true;
                break;
            }
        }
        if(!found) {
            permissionRepository.save(p);
            roleRepository.save(r);

            temp.setRoles(roles);
            userRepository.save(temp);

        }
    }
    }

}
