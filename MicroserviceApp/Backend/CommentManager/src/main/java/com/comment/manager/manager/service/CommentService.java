package com.comment.manager.manager.service;


import com.comment.manager.manager.model.AdvertCopy;
import com.comment.manager.manager.model.Comment;
import org.springframework.stereotype.Service;


public interface CommentService {

    boolean createComment(Comment comment, AdvertCopy advertCopy);
}
