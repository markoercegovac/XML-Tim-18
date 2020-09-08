package com.team18.WebServiceManager.repository;

import com.team18.WebServiceManager.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
	Comment findByAgentAgentIdAndKeyMS(Long agId, Long keyMS);
	Comment findByAgentAgentIdAndKeyAG(Long agId, Long keyAG);
	List<Comment> findByAgentAgentIdOrderByKeyMSDesc(Long adId);
}
