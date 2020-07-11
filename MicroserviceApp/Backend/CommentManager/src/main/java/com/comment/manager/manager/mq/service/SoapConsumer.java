package com.comment.manager.manager.mq.service;

import com.comment.manager.manager.model.AdvertCopy;
import com.comment.manager.manager.model.Comment;
import com.comment.manager.manager.model.enums.CommentState;
import com.comment.manager.manager.mq.dto.AdCommentMQ;
import com.comment.manager.manager.mq.dto.CommentMQ;
import com.comment.manager.manager.repository.CommentRepository;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class SoapConsumer {

	@Autowired
	private Gson gson;
	@Autowired
	private CommentRepository commentRepository;

	@RabbitListener(queues = "${rabbitmq.queue.soap}")
	public void recievedMessage(String msg) {
		System.out.println("MQ>> Got from SOAP" + msg);

		try {
			CommentMQ recived = gson.fromJson(msg, CommentMQ.class);

			Comment com = new Comment();
			com.setId(recived.getId());
			com.setAdvertId(recived.getAdvertId());
			com.setCommentState(CommentState.NEW);
			com.setContent(recived.getContent());
			com.setCreationDate(recived.getCreationDate());
			com.setHeader(recived.getHeader());
			com.setUserEmail(recived.getUserEmail());

			commentRepository.save(com);
		} catch(Exception e) {
			System.out.println("MQ>> EXCEPTION");
		}
	}
}
