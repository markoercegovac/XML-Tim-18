package com.team18.WebServiceManager.mq.service.producer;

import com.google.gson.Gson;
import com.team18.WebServiceManager.mq.dto.ReservationMQ;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ReservationProducer {

	@Autowired
	private Gson gson;
	@Autowired
	private AmqpTemplate amqpTemplate;

	@Value("${rabbitmq.direct.soap.soap.request}")
	private String exchange;

	@Value("${rabbitmq.key.soap.soap.request}")
	private String routingKey;

	public void produceReservation(ReservationMQ msg){
		amqpTemplate.convertAndSend(exchange, routingKey, gson.toJson(msg));
		System.out.println("MQ>> sending car reservation "+ msg);
	}
}
