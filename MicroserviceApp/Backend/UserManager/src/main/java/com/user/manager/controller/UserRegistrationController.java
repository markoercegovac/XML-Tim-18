package com.user.manager.controller;

import com.user.manager.dto.CreateUserDTO;
import com.user.manager.services.UserRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserRegistrationController {

    private final UserRegistrationService registerUser;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<String> registerAgent(@RequestBody CreateUserDTO dto) {
        HttpStatus status = HttpStatus.CREATED;
        try {
            this.registerUser.register(dto);
        } catch(NullPointerException e) {
            status = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<String>(status);
    }
}
