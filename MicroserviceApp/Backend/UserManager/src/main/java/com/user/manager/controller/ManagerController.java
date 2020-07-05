package com.user.manager.controller;

import com.user.manager.dto.ChangeUserDto;
import com.user.manager.dto.RegistrationDto;
import com.user.manager.dto.UserDto;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping()
@RestController
public class ManagerController {



    @GetMapping("/admin/user-manager")
    public ResponseEntity<List<UserDto>> getUsers(@RequestBody UserDto userDto){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/admin/user-manager/change-user")
    public ResponseEntity<ChangeUserDto> changeUser(@RequestBody ChangeUserDto changeUserDto){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/admin/user-manager/registration-request")
    public ResponseEntity<List<RegistrationDto>> registrationRequests(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/admin/user-manager/registration-request")
    public ResponseEntity<RegistrationDto> acceptRequest(@RequestBody RegistrationDto registrationDto){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/admin/user-manager/registration-request")
    public ResponseEntity<RegistrationDto> rejectRequest(@RequestBody RegistrationDto registrationDto){
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
