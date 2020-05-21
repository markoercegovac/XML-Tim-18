package com.comment.manager.manager.repository;

import com.comment.manager.manager.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
