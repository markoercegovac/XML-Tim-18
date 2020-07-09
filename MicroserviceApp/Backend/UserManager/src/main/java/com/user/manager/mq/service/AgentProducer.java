package com.user.manager.mq.service;

import com.google.gson.Gson;
import com.user.manager.mq.dto.AgentMQ;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AgentProducer {
	@Autowired
	private Gson gson;
	@Autowired
	private AmqpTemplate amqpTemplate;

	@Value("${rabbitmq.exchange.soap}")
	private String exchange;

	@Value("${rabbitmq.routingkey.soap}")
	private String routingKey;

	public void produceMsg(AgentMQ msg){
		amqpTemplate.convertAndSend(exchange, routingKey, gson.toJson(msg));
		System.out.println("MQ>> sending to mail "+ msg);
	}
}
