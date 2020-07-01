package com.comment.manager.manager.mq.service;

import java.sql.Date;

import com.comment.manager.manager.model.AdvertCopy;
import com.comment.manager.manager.mq.dto.AdCommentMQ;
import com.comment.manager.manager.repository.AdvertCopyRepository;
import com.google.gson.Gson;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdvertConsumer {

	@Autowired
	private Gson gson;
	@Autowired
	private AdvertCopyRepository advertCopyRepository;

	@RabbitListener(queues = "${rabbitmq.queue.from.advert}")
	public void recievedMessage(String msg) {
		System.out.println("MQ>> Got from user manager" + msg);

		try {
			AdCommentMQ recived = gson.fromJson(msg, AdCommentMQ.class);

			AdvertCopy adCopy = new AdvertCopy();
			adCopy.setId(recived.getId());
			adCopy.setEndDate((Date) recived.getEndDate());
			adCopy.setStartDate((Date) recived.getStartDate());
			adCopy.setOwnerEmail(recived.getOwnerEmail());

			advertCopyRepository.save(adCopy);
		} catch(Exception e) {
			System.out.println("MQ>> EXCEPTION");
		}
    }
}