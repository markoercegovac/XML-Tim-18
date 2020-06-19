package com.comment.manager.manager.service.impl;

import com.comment.manager.manager.model.AdvertCopy;
import com.comment.manager.manager.model.Comment;
import com.comment.manager.manager.model.enums.CommentState;
import com.comment.manager.manager.repository.CommentRepository;
import com.comment.manager.manager.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;



    @Override
    public boolean createComment(Comment comment, AdvertCopy advertCopy) {

        Date todayDate = new Date();
        if(!advertCopy.getEndDate().after(todayDate)) {

            // NAPOMENA! TREBA DODATI ID OGLASA,DOGOVORITI SE OKO TOGA.
            comment.setCommentState(CommentState.NEW);
            comment.setCreationDate(new Date());
            //setujem trenutni datum kad je kreiran :)
            commentRepository.save(comment);

            return true;

        }
        return false;
    }
}
