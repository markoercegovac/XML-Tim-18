package com.example.request.mq.service;

import com.example.request.mq.dto.MailMessage;
import com.example.request.mq.dto.ReservedCarSearchMQ;
import com.google.gson.Gson;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SearchProducer {

	@Autowired
	private Gson gson;

	@Autowired
	private AmqpTemplate amqpTemplate;

	@Value("${rabbitmq.exchange.search}")
	private String exchange;

	@Value("${rabbitmq.routingkey.search}")
	private String routingKey;

	public void sendSearch(ReservedCarSearchMQ msg) {
		amqpTemplate.convertAndSend(exchange, routingKey, gson.toJson(msg));
	}
}
