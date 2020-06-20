package rent.app.controller.rest;

import lombok.RequiredArgsConstructor;
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

    @GetMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<List<CommentDTO>> getAllCommentsOfAdvert(@PathVariable("id") Long id) {
        List<CommentDTO> comments = commentService.getAllCommentsOfAd(id);

        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PostMapping(value = "/add", consumes = "application/json")
    public ResponseEntity<?> createComment(@RequestBody CommentDTO comment) {

        if(commentService.addNewComment(comment)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

}
