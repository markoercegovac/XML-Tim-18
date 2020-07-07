package com.user.manager.controller;

import com.user.manager.dto.AgentDTO;
import com.user.manager.services.AgentRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/agent")
@RequiredArgsConstructor
@RestController
public class AgentRegistrationController {

    private final AgentRegistrationService agentRegistrationService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<String> registerAgent(@RequestBody AgentDTO dto) {
        HttpStatus status = HttpStatus.CREATED;
        try {
            this.agentRegistrationService.register(dto);
        } catch(NullPointerException e) {
            status = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<String>(status);
    }

}
