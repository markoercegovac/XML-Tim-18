package com.user.manager.controller;


import com.user.manager.mapper.DtoEntity;
import com.user.manager.model.User;
import com.user.manager.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/admin")
@RequiredArgsConstructor
@RestController
public class BanController {

    private final UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<DtoEntity>> getUsers(){
        List<DtoEntity> dtoEntities=userService.allUsers();
        return new ResponseEntity<>(userService.allUsers(),HttpStatus.OK);

    }

    @PostMapping("/ban")
    public void banUser (@RequestBody User user) {
        User temp=userService.getUser(user.getEmail());
        temp.setBanned(true);
        userService.saveUser(temp);
    }

    @PostMapping("/unban")
    public void unBanUser (@RequestBody User user) {
        User temp=userService.getUser(user.getEmail());
        temp.setBanned(false);
        userService.saveUser(temp);
    }

    @PostMapping("/delete")
    public void deleteUser(@RequestBody User user) {
        User temp=userService.getUser(user.getEmail());
        userService.deleteUser(temp);
    }

    @PostMapping("/make-admin")
    public void setAdminRole (@RequestBody User user) {
        userService.addAdminRole(user);
    }
}
