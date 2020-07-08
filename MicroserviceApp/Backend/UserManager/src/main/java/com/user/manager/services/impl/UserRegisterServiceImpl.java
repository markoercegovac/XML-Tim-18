package com.user.manager.services.impl;

import com.user.manager.dto.CreateUserDTO;
import com.user.manager.model.Permission;
import com.user.manager.model.Role;
import com.user.manager.model.User;
import com.user.manager.repository.RoleRepository;
import com.user.manager.repository.UserRepository;
import com.user.manager.services.UserRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserRegisterServiceImpl implements UserRegistrationService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional(rollbackFor = NullPointerException.class)
    public void register(CreateUserDTO dto) throws NullPointerException {

        Role userR = roleRepository.findByName("USER");
        if(userR == null) {
            userR = createRole("USER");
        }

        List<Role> roleList=new ArrayList<Role>();
        roleList.add(userR);

        User user = new User();
        user.setEmail(dto.getEmail());
        user.setUsername(dto.getUsername());
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());
        user.setState(dto.getState());
        user.setCity(dto.getCity());
        user.setStreet(dto.getStreet());
        user.setStreetNumber(dto.getStreetNumber());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setBanned(true);
        user.setForbiddenAdvert(false);
        user.setRemoved(false);
        user.setAdminApproved(false);
        user.setRoles(roleList);

        userRepository.save(user);
    }

    private Role createRole(String name) {
        Permission p=new Permission();
        p.setName(name);

        List<Permission> list=new ArrayList<Permission>();
        list.add(p);

        Role role = new Role();
        role.setName(name);
        role.setPermissions(list);
        roleRepository.save(role);

        return role;
    };
}
