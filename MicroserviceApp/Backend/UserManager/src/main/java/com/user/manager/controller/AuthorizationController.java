package com.user.manager.controller;

import com.user.manager.dto.LoginDto;
import com.user.manager.dto.RegistrationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user-manager")
@RequiredArgsConstructor
@RestController
@CrossOrigin
public class AuthorizationController {

    @PostMapping("/login")
    public ResponseEntity<LoginDto> login(@RequestBody LoginDto loginDto){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<RegistrationDto> register(@RequestBody RegistrationDto registerDto){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/test")
    public String test(){
        return "Hello";
    };


}


