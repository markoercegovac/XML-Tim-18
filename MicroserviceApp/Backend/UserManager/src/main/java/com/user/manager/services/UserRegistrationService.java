package com.user.manager.services;

import com.user.manager.dto.CreateUserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserRegistrationService {

    void register(CreateUserDTO dto) throws NullPointerException;
}
