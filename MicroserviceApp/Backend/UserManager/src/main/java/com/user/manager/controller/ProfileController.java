package com.user.manager.controller;

import com.user.manager.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/user-manager")
@RestController
@CrossOrigin
public class ProfileController {

    private static final Logger logger = LoggerFactory.getLogger("DebugLogger");
    String className = " [" + ProfileController.class.getName() +"] ";

    @GetMapping("/profile")
    public ResponseEntity<UserDto> userProfile(){
        logger.debug(className + "Vrati profil korisnika");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping ("/profile")
    public ResponseEntity<UserDto> changeProfile(){
        logger.debug(className + "Promeni profil korisnika");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
