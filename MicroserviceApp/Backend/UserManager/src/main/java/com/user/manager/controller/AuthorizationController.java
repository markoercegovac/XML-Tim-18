package com.user.manager.controller;

import com.user.manager.dto.LoginDto;
import com.user.manager.dto.RegistrationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RequestMapping()
@RequiredArgsConstructor
@RestController
@CrossOrigin
public class AuthorizationController {


    @GetMapping("/user/me")
    public Principal user(Principal principal) {
        System.out.println(principal);
        return principal;
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


