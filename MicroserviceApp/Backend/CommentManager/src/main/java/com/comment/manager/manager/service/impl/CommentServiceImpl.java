package com.comment.manager.manager.service.impl;

import com.comment.manager.manager.model.AdvertCopy;
import com.comment.manager.manager.model.Comment;
import com.comment.manager.manager.model.enums.CommentState;
import com.comment.manager.manager.repository.CommentRepository;
import com.comment.manager.manager.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;



    @Override
    public boolean createComment(Comment comment, AdvertCopy advertCopy) {

        Date todayDate = new Date();
        if(!advertCopy.getEndDate().after(todayDate)) {


            comment.setCommentState(CommentState.NEW);
            comment.setCreationDate(new Date());
            //setujem trenutni datum kad je kreiran :)
            commentRepository.save(comment);

            return true;

        }
        return false;
    }

    @Override
    public List<Comment> findAllNew() {
        ArrayList<Comment> komentari = new ArrayList<Comment> (commentRepository.findAll());
        ArrayList<Comment> resenje =new ArrayList<Comment> ();
        for(Comment kom: komentari) {
            if(kom.getCommentState()== CommentState.NEW){
                resenje.add(kom);
            }
        }
        return resenje;
    }

    @Override
    public void setApproved(Long id) {
        Comment com = commentRepository.findById(id).get();
        com.setCommentState(CommentState.APPROVED);
        commentRepository.save(com);
    }

    @Override
    public void setRejected(Long id) {

        Comment com = commentRepository.findById(id).get();
        com.setCommentState(CommentState.REJECTED);
        commentRepository.save(com);
    }

    @Override
    public List<Comment> getAllApprovedFromOneAdvert(Long id) {

        ArrayList<Comment> komentatri =  new ArrayList<Comment>(commentRepository.findAll());
        ArrayList<Comment> resenje = new ArrayList<Comment>();

        for(Comment kom : komentatri) {
            if(kom.getCommentState()==CommentState.APPROVED && kom.getAdvertId()==id) {
                resenje.add(kom);
            }
        }
        return resenje;
    }
}
