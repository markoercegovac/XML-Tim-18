package com.user.manager.controller;

import com.user.manager.dto.RegistrationDto;
import com.user.manager.services.AdminRegistrationService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/admin/user-manager/registration-request")
@RestController
public class ManagerController {

    private final AdminRegistrationService adminRegistrationService;

    @GetMapping
    public ResponseEntity<List<RegistrationDto>> registrationRequests(){
        return new ResponseEntity<>(
                this.adminRegistrationService.getRequests(),
                HttpStatus.OK);
    }

    @PutMapping("/{email}")
    public ResponseEntity<String> acceptRequest(@PathVariable("email") String email){
        this.adminRegistrationService.accept(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<String> rejectRequest(@PathVariable("email") String email){
        this.adminRegistrationService.decline(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
