package com.comment.manager.manager.service;


import com.comment.manager.manager.model.AdvertCopy;
import com.comment.manager.manager.model.Comment;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CommentService {

    boolean createComment(Comment comment, AdvertCopy advertCopy);

    List<Comment> findAllNew();

    void setApproved(Long id);

    void setRejected(Long id);

    List<Comment> getAllApprovedFromOneAdvert(Long id);
}
