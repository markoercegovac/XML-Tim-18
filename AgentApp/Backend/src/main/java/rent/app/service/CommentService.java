package rent.app.service;

import org.springframework.stereotype.Service;
import rent.app.dto.CommentDTO;
import rent.app.model.Comment;

import java.util.List;

@Service
public interface CommentService {

    List<CommentDTO> getAllCommentsOfAd(Long adId);

    Comment addNewComment(CommentDTO newComment, String author);
}
