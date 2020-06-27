package com.user.manager.controller;

import com.user.manager.dto.ChangeUserDto;
import com.user.manager.dto.RegistrationDto;
import com.user.manager.dto.UserDto;
import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/user-manager")
@RestController
@CrossOrigin
public class ManagerController {

    private static final Logger logger = LoggerFactory.getLogger("DebugLogger");
    String className = " [" + ManagerController.class.getName() +"] ";

    @GetMapping("/admin/user-manager")
    public ResponseEntity<List<UserDto>> getUsers(@RequestBody UserDto userDto){
        logger.debug(className + "Preuzmi sve korisnike");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/admin/user-manager/change-user")
    public ResponseEntity<ChangeUserDto> changeUser(@RequestBody ChangeUserDto changeUserDto){
        logger.debug(className + "Izmeni korisnika sa id: "+ changeUserDto.getEmail());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/admin/user-manager/registration-request")
    public ResponseEntity<List<RegistrationDto>> registrationRequests(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/admin/user-manager/registration-request")
    public ResponseEntity<RegistrationDto> acceptRequest(@RequestBody RegistrationDto registrationDto){
        logger.debug(className + "Prihvati zahtev");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/admin/user-manager/registration-request")
    public ResponseEntity<RegistrationDto> rejectRequest(@RequestBody RegistrationDto registrationDto){
        logger.debug(className + "Odbij zahtev");
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
