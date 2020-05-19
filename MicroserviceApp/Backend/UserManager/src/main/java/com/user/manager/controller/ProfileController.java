package com.user.manager.controller;

import com.user.manager.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/user-manager")
@RestController
@CrossOrigin
public class ProfileController {

    @GetMapping("/profile")
    public ResponseEntity<UserDto> userProfile(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping ("/profile")
    public ResponseEntity<UserDto> changeProfile(){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
