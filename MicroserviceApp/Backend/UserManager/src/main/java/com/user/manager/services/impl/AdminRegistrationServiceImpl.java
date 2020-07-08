package com.user.manager.services.impl;

import com.user.manager.dto.RegistrationDto;
import com.user.manager.model.User;
import com.user.manager.repository.UserRepository;
import com.user.manager.services.AdminRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminRegistrationServiceImpl implements AdminRegistrationService {

    private final UserRepository users;

    @Override
    public List<RegistrationDto> getRequests() {
        List<RegistrationDto> requestsDto = new ArrayList<>();
        List<User> requests = users.findAllByAdminApprovedFalse();
        requests.forEach(request -> {
           RegistrationDto r = new RegistrationDto();
           r.setEmail(request.getEmail());
           r.setUsername(request.getUsername()==null?"":request.getUsername());
           r.setName(request.getName()==null?"":request.getName());
           r.setSurname(request.getSurname()==null?"":request.getSurname());
           r.setCompanyName(request.getCompanyName()==null?"":request.getCompanyName());
           r.setCompanyRegistrationNumber(request.getCompanyRegistrationNumber()==null?"":request.getCompanyRegistrationNumber());
           r.setState(request.getState());
           r.setCity(request.getCity());
           r.setStreet(request.getStreet());
           r.setStreetNumber(request.getStreetNumber());
           r.setUrl(request.getAgentUrl()==null?"":request.getAgentUrl());

           if(!r.getUsername().isEmpty()) {
                r.setState("USER");
           } else if(r.getUrl().isEmpty()) {
               r.setState("FIRM");
           } else {
               r.setState("AGENT");
           }

           requestsDto.add(r);
        });

        return requestsDto;
    }

    @Override
    public void accept(String email) {
        User user = users.getOne(email);
        user.setBanned(false);
        user.setAdminApproved(true);
        user.setRemoved(false);

        users.save(user);
    }

    @Override
    public void decline(String email) {
        User user = users.getOne(email);
        user.setAdminApproved(true);
        user.setRemoved(true);

        users.save(user);
    }
}
