package rent.app.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rent.app.dto.CommentDTO;
import rent.app.service.CommentService;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
@CrossOrigin
public class CommentController {

    private final CommentService commentService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<CommentDTO>> getAllCommentsOfAdvert(@PathVariable("id") Long id) {
        List<CommentDTO> comments = commentService.getAllCommentsOfAd(id);

        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PostMapping(value = "/add", consumes = "application/json")
    public ResponseEntity<?> createComment(@RequestBody CommentDTO comment, Principal principal) {

        commentService.addNewComment(comment,principal.getName());

            return new ResponseEntity<>( HttpStatus.OK);

    }

}
