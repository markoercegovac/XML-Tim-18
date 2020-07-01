package com.team18.xml.MailManager.service;

import com.google.gson.Gson;
import com.team18.xml.MailManager.model.CommentMail;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentService {
	
	@Autowired
	private MyMailSender mailSender;
	@Autowired
	private Gson gson;

	@RabbitListener(queues="${rabbitmq.queue.from.comment}")
	public void received(String msg) {

		CommentMail comment = (CommentMail) gson.fromJson(msg, CommentMail.class);
		String content = "Dear sir or madam,\nUser "
			+ comment.getUserEmail()
			+ " has added comment to your advert./n"
			+ "Comment: "
			+comment.getComment();

		mailSender.send(comment.getOwnerEmail(), "GOT COMMENT", content);
	}
}