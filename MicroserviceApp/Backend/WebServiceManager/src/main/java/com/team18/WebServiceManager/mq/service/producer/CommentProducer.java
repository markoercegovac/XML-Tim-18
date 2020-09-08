package com.team18.WebServiceManager.mq.service.producer;

import com.google.gson.Gson;
import com.team18.WebServiceManager.mq.dto.CommentMQ;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CommentProducer {
	@Autowired
	private Gson gson;
	@Autowired
	private AmqpTemplate amqpTemplate;

	@Value("${rabbitmq.direct.soap.soap.comment}")
	private String exchange;

	@Value("${rabbitmq.key.soap.soap.comment}")
	private String routingKey;

	public void produceComment(CommentMQ msg){
		amqpTemplate.convertAndSend(exchange, routingKey, gson.toJson(msg));
		System.out.println("MQ>> sending car brand "+ msg);
	}
}
