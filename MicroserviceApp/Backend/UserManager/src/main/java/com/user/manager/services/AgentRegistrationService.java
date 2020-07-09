package com.user.manager.services;

import com.user.manager.dto.AgentDTO;
import org.springframework.stereotype.Service;

@Service
public interface AgentRegistrationService {

    public void register(AgentDTO dto) throws NullPointerException;
}
