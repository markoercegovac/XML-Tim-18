package com.comment.manager.manager.controller;

import com.comment.manager.manager.model.Comment;
import com.comment.manager.manager.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/comment-manager")
public class ManagerController {

    private final CommentRepository commentRepository;

    @GetMapping(value = "/test", produces = "application/text")
    public String getTest() {
        Comment c=new Comment();
        c.setId(1l);
        commentRepository.save(c);
        return "TEST FROM COMMENT";
    }
}
