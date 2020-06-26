package com.user.manager.comon;

import com.google.gson.Gson;
import com.user.manager.model.Mail;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MailProducer {
	
	@Autowired
	private Gson gson;

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${rabbitmq.exchange.mail}")
	private String exchange;
	
	@Value("${rabbitmq.routingkey.mail}")
	private String routingKey;
	
	public void produceMsg(Mail msg){
		amqpTemplate.convertAndSend(exchange, routingKey, gson.toJson(msg));
	}
}