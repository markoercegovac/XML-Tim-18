package com.comment.manager.manager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/comment-manager")
public class ManagerController {

    @GetMapping(value = "/test", produces = "application/text")
    public String getTest() {
        return "TEST FROM COMMENT";
    }
}
