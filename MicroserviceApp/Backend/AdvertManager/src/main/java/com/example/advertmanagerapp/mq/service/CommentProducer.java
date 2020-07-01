package com.example.advertmanagerapp.mq.service;

import com.example.advertmanagerapp.mq.dto.AdCommentMQ;
import com.google.gson.Gson;

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
	
	@Value("${rabbitmq.exchange.comment}")
	private String exchange;
	
	@Value("${rabbitmq.routingkey.comment}")
	private String routingKey;
	
	public void produceMsg(AdCommentMQ msg){
		amqpTemplate.convertAndSend(exchange, routingKey, gson.toJson(msg));
		System.out.println("MQ>>Send to comment manager = " + msg);
	}
}