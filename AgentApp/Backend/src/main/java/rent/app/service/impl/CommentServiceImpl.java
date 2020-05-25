package rent.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rent.app.dto.CommentDTO;

import rent.app.model.Comment;
import rent.app.repository.CommentRepository;
import rent.app.service.CommentService;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl  implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public List<CommentDTO> getAllCommentsOfAd(Long adId) {
        List<Comment> comments = commentRepository.findAllByAdvertId(adId);
        List<CommentDTO> commentsDTO = new ArrayList<>();

        for(Comment comment: comments) {
            CommentDTO com = new CommentDTO();
            com.setCommentId(comment.getId());
            com.setAdvertId(comment.getAdvert().getId());
            com.setAuthor(comment.getClient().getEmail());
            com.setContent(comment.getContent());

            commentsDTO.add(com);
        }

        return commentsDTO;
    }

    @Override
    public boolean addNewComment(CommentDTO newComment) {

        Comment comment = new Comment();

        return false;
    }
}
