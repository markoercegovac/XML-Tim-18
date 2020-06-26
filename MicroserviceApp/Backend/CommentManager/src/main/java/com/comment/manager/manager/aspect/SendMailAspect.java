package com.comment.manager.manager.aspect;

import com.comment.manager.manager.comon.MailProducer;
import com.comment.manager.manager.model.AdvertCopy;
import com.comment.manager.manager.model.Comment;
import com.comment.manager.manager.model.Mail;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SendMailAspect {
	
	@Autowired
	private MailProducer mailProducer;

	@After(value = "execution(* com.comment.manager.manager.service.impl.CommentServiceImpl.createComment(..)) and args(comment, advertCopy)")
	public void sendEmail(JoinPoint joinPoint, Comment comment, AdvertCopy advertCopy) {
		
		Mail msg = new Mail(
			advertCopy.getOwnerEmail(),
			comment.getUserEmail(),
			comment.getContent()
		);

		mailProducer.produceMsg(msg);
	}
}