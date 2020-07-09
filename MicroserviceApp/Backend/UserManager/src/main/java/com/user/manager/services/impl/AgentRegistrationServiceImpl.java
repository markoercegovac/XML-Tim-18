package com.user.manager.services.impl;

import com.user.manager.dto.AgentDTO;
import com.user.manager.model.Permission;
import com.user.manager.model.Role;
import com.user.manager.model.User;
import com.user.manager.repository.RoleRepository;
import com.user.manager.repository.UserRepository;
import com.user.manager.services.AgentRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AgentRegistrationServiceImpl implements AgentRegistrationService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional(rollbackFor = NullPointerException.class)
    public void register(AgentDTO dto) throws NullPointerException{
        User user = new User();

        Role owner = roleRepository.findByName("OWNER");
        Role agent = roleRepository.findByName("AGENT");
        if(owner == null) {
            owner = createRole("OWNER");
        }
        if(agent == null) {
            agent = createRole("AGRNT");
        }

        List<Role> roleList=new ArrayList<Role>();
        roleList.add(owner);

        //OWNER IS ACTUALLY AN AGENT
        if(dto.getUrl() != null && !dto.getUrl().trim().isEmpty()) {
            user.setAgentUrl(dto.getUrl());
            roleList.add(agent);
        }

        user.setEmail(dto.getEmail());
        user.setCompanyName(dto.getCompany());
        user.setState(dto.getState());
        user.setCity(dto.getCity());
        user.setStreet(dto.getStreet());
        user.setStreetNumber(dto.getStreetNumber());
        user.setCompanyRegistrationNumber(dto.getRegistrationNumber());
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
