package com.user.manager.controller;


import com.user.manager.dto.UserDto;
import com.user.manager.model.Role;
import com.user.manager.model.User;
import com.user.manager.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/user-manager/admin")
@RequiredArgsConstructor
@RestController
@CrossOrigin
public class BanController {

    private final UserService userService;



    @GetMapping("/all")
    public List<UserDto> getUsers(@RequestBody UserDto userDto){
        return userService.allUsers();
    }

    @PostMapping("/ban")
    public void banUser (@RequestBody User user) {
        user.setBanned(true);
        userService.saveUser(user);
    }

    @PostMapping("/unban")
    public void unBanUser (@RequestBody User user) {
        user.setBanned(false);
        userService.saveUser(user);
    }

    @PostMapping("/delete")
    public void deleteUser(@RequestBody User user) {
        userService.deleteUser(user);
    }

    @PostMapping("/make-admin")
    public void setAdminRole (@RequestBody User user) {
        userService.addAdminRole(user);
    }
}
