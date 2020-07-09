package com.user.manager.services;

import com.user.manager.dto.RegistrationDto;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface AdminRegistrationService {

    List<RegistrationDto> getRequests();
    void accept(String email);
    void decline(String email);
}
