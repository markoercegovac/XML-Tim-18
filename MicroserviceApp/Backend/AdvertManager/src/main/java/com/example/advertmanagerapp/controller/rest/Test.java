package com.example.advertmanagerapp.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/advert-manager/test")
@RestController
@CrossOrigin
public class Test {

    @GetMapping
    public String hello(){
        return "Hello from advert-manager";
    }
}
