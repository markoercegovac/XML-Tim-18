package rent.app.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rent.app.dto.CommentDTO;
import rent.app.service.CommentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
@CrossOrigin(origins = "http://localhost:4200")
public class CommentController {

    private final CommentService commentService;
    private static final Logger logger = LoggerFactory.getLogger("DebugLogger");
    String className = " [" + CommentController.class.getName() +"] ";

    @GetMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<List<CommentDTO>> getAllCommentsOfAdvert(@PathVariable("id") Long id) {
        logger.debug(className +" Dobavljanje svih komentara od oglasa sa id: " + id);
        List<CommentDTO> comments = commentService.getAllCommentsOfAd(id);

        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PostMapping(value = "/add", consumes = "application/json")
    public ResponseEntity createComment(@RequestBody CommentDTO comment) {

        if(commentService.addNewComment(comment)) {
            logger.debug(className +" Dodat komentar sa id: " + comment.getCommentId());
            return new ResponseEntity(HttpStatus.OK);
        } else {
            logger.error(className+"Greska prilikom kreiranja komentara sa id:" + comment.getCommentId());

            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        }
    }

}
