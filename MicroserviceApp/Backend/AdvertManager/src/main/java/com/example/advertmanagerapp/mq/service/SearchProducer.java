package com.example.advertmanagerapp.mq.service;

import com.example.advertmanagerapp.mq.dto.AdSearchMQ;
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
	
	public void produceMsg(AdSearchMQ msg){
		amqpTemplate.convertAndSend(exchange, routingKey, gson.toJson(msg));
		System.out.println("MQ>>Send to search manager = " + msg);
	}
}