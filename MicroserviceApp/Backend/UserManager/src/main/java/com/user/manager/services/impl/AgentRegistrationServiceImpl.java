package com.user.manager.services.impl;

import com.user.manager.dto.AgentDTO;
import com.user.manager.model.Role;
import com.user.manager.model.User;
import com.user.manager.repository.PermissionRepository;
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

        Role owner = roleRepository.findByName("OWNER");
        if(owner == null) {
            throw new NullPointerException();
        }

        List<Role> roleList=new ArrayList<Role>();
        roleList.add(owner);

        User user = new User();
        user.setEmail(dto.getEmail());
        user.setUsername(dto.getCompany());
        user.setState(dto.getState());
        user.setCity(dto.getCity());
        user.setStreet(dto.getStreet());
        user.setStreetNumber(dto.getStreetNumber());
        user.setCompanyRegistrationNumber(dto.getRegistrationNumber());
        user.setAgentUrl(dto.getUrl());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setBanned(false);
        user.setForbiddenAdvert(false);
        user.setRemoved(false);
        user.setAdminApproved(false);
        user.setRoles(roleList);

        userRepository.save(user);
    }
}
