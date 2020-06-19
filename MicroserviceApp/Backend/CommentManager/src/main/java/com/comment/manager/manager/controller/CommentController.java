package com.comment.manager.manager.controller;

import com.comment.manager.manager.dto.CommentDto;
import com.comment.manager.manager.model.Comment;
import com.comment.manager.manager.service.AdvertCopyService;
import com.comment.manager.manager.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/comment-manager")
@RestController
@CrossOrigin
public class CommentController {

    private final CommentService commentService;

    private final AdvertCopyService advertCopyService;

    public CommentController(CommentService commentService, AdvertCopyService advertCopyService) {
        this.commentService = commentService;
        this.advertCopyService = advertCopyService;
    }

    @GetMapping("/comment/{idAdvert}")
    public ResponseEntity<List<CommentDto>>getAdvertComments(@PathVariable String idAdvert){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/comment")
    public ResponseEntity<Comment> postComment(@RequestBody Comment commentDto){

        System.out.println(commentDto.getAdvertId());
        if(advertCopyService.getAdvertCopy(commentDto.getAdvertId())!=null) {
                commentService.createComment(commentDto,advertCopyService.getAdvertCopy(commentDto.getAdvertId()));


            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
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
