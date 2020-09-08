package com.comment.manager.manager.aspect;

import com.comment.manager.manager.model.Comment;
import com.comment.manager.manager.mq.dto.CommentMQ;
import com.comment.manager.manager.mq.service.SoapProducer;
import com.comment.manager.manager.repository.CommentRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SoapAspect {

	@Autowired
	private SoapProducer soapProducer;
	@Autowired
	private CommentRepository commentRepository;

	@After(value = "execution(* com.comment.manager.manager.service.impl.CommentServiceImpl.setApproved(..)) and args(id)")
	public void sendEmail(JoinPoint joinPoint, Long id) {

		Comment com = commentRepository.getOne(id);
		CommentMQ msg = new CommentMQ();
		msg.setAdvertId(com.getAdvertId());
		msg.setContent(com.getContent());
		msg.setCreationDate(com.getCreationDate());
		msg.setHeader(com.getHeader());
		msg.setUserEmail(com.getUserEmail());
		msg.setId(id);

		soapProducer.produceMsg(msg);
	}
}
