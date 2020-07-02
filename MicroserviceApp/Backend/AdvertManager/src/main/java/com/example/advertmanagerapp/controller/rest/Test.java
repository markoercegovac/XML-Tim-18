package com.example.advertmanagerapp.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RequiredArgsConstructor
@RequestMapping("/advert-manager/test")
@RestController
public class Test {

    @GetMapping
    public String hello(Principal principal){
        System.out.print(principal.getName());
        return "hello";
    }
}
