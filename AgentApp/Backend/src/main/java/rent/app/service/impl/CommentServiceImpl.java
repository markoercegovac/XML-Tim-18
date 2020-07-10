package rent.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rent.app.dto.CommentDTO;

import rent.app.model.Advert;
import rent.app.model.Comment;
import rent.app.repository.AdvertRepository;
import rent.app.repository.CommentRepository;
import rent.app.service.CommentService;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl  implements CommentService {

    private final CommentRepository commentRepository;
    private final AdvertRepository advertRepository;

    @Override
    public List<CommentDTO> getAllCommentsOfAd(Long adId) {
        List<Comment> comments = commentRepository.findAllByAdvertId(adId);
        List<CommentDTO> commentsDTO = new ArrayList<>();

        for(Comment comment: comments) {
            CommentDTO com = new CommentDTO();
            com.setCommentId(comment.getId());
            com.setAdvertId(comment.getAdvert().getId());
            com.setAuthor(comment.getAuthor());
            com.setContent(comment.getContent());

            commentsDTO.add(com);
        }

        return commentsDTO;
    }

    @Override
    public void addNewComment(CommentDTO newComment,String author) {

        Comment comment = new Comment();
        Advert advert = advertRepository.findAllById(newComment.getAdvertId());
        comment.setId(newComment.getCommentId());
        comment.setAdvert(advert);
        comment.setAuthor(author);
        comment.setContent(newComment.getContent());
        commentRepository.save(comment);


    }
}
