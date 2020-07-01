package com.example.request.mq.service;

import com.example.request.mq.dto.ChatMQ;
import com.google.gson.Gson;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ChatProducer {
	
	@Autowired
	private Gson gson;

	@Autowired
	private AmqpTemplate amqpTemplate;

	@Value("${rabbitmq.exchange.chat}")
	private String exchange;

	@Value("${rabbitmq.routingkey.chat}")
	private String routingKey;

	public void send(ChatMQ msg) {
		amqpTemplate.convertAndSend(exchange, routingKey, gson.toJson(msg));
	}
}