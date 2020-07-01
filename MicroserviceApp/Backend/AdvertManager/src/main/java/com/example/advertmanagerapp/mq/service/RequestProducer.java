package com.example.advertmanagerapp.mq.service;

import com.example.advertmanagerapp.mq.dto.AdRequestMQ;
import com.google.gson.Gson;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RequestProducer {
	
	@Autowired
	private Gson gson;

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${rabbitmq.exchange.request}")
	private String exchange;
	
	@Value("${rabbitmq.routingkey.request}")
	private String routingKey;
	
	public void produceMsg(AdRequestMQ msg){
		amqpTemplate.convertAndSend(exchange, routingKey, gson.toJson(msg));
		System.out.println("MQ>>Send to request manager = " + msg);
	}
}