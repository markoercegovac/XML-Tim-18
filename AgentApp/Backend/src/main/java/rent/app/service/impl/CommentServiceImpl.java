package rent.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rent.app.dto.CommentDTO;
import rent.app.model.Comment;
import rent.app.repository.CommentRepository;
import rent.app.service.CommentService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl  implements CommentService {

    private CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<CommentDTO> getAllCommentsOfAd(Long adId) {
        List<Comment> comments = commentRepository.findAllByAdvertId(adId);
        List<CommentDTO> commentsDTO = new ArrayList<>();

        for(Comment comment: comments) {
            commentsDTO.add(new CommentDTO(

            ));
        }

        return commentsDTO;
    }
}
