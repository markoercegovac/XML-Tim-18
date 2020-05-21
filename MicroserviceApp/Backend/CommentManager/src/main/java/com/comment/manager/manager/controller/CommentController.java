package com.comment.manager.manager.controller;

import com.comment.manager.manager.dto.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/comment-manager")
@RestController
@CrossOrigin
public class CommentController {

    @GetMapping("/comment/{idAdvert}")
    public ResponseEntity<List<CommentDto>>getAdvertComments(@PathVariable String idAdvert){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/comment")
    public ResponseEntity<CommentDto> postComment(@RequestBody CommentDto commentDto){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/admin/comment-manager/all")
    public ResponseEntity<List<CommentDto>>getAllComments(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/admin/comment-manager/")
    public ResponseEntity<CommentDto> approvedComment(@RequestBody CommentDto commentDto){
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/admin/comment-manager/")
    public ResponseEntity<CommentDto> removeComment(@RequestBody CommentDto commentDto){
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
