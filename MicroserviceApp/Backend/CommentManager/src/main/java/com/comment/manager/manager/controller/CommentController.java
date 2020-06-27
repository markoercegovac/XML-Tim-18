package com.comment.manager.manager.controller;

import com.comment.manager.manager.dto.CommentDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/comment-manager")
@RestController
@CrossOrigin
public class CommentController {

    private static final Logger logger = LoggerFactory.getLogger("DebugLogger");
    String className = " [" + CommentController.class.getName() +"] ";

    @GetMapping("/comment/{idAdvert}")
    public ResponseEntity<List<CommentDto>>getAdvertComments(@PathVariable String idAdvert){
        logger.debug(className + "Preuzmi komentare sa id: "+ idAdvert);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/comment")
    public ResponseEntity<CommentDto> postComment(@RequestBody CommentDto commentDto){
        logger.debug(className + "Kreiraj komentar sa id: "+ commentDto.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/admin/comment-manager/all")
    public ResponseEntity<List<CommentDto>>getAllComments() {
        logger.debug(className + "Preuzmi sve komentare");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/admin/comment-manager/")
    public ResponseEntity<CommentDto> approvedComment(@RequestBody CommentDto commentDto){
        logger.debug(className + "Odobri komentar sa id: "+ commentDto.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/admin/comment-manager/")
    public ResponseEntity<CommentDto> removeComment(@RequestBody CommentDto commentDto){
        logger.debug(className + "Obrisi komentar sa id: "+ commentDto.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
