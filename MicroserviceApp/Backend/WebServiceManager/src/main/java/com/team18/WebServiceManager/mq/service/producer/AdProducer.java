package com.team18.WebServiceManager.mq.service.producer;

import com.google.gson.Gson;
import com.team18.WebServiceManager.mq.dto.*;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AdProducer {

	@Autowired
	private Gson gson;
	@Autowired
	private AmqpTemplate amqpTemplate;

	@Value("${rabbitmq.direct.soap.ad.soap}")
	private String exchange;

	@Value("${rabbitmq.key.soap.ad.soap}")
	private String routingKey;

	public void produceCarBrand(CarBrandMQ msg){
		amqpTemplate.convertAndSend(exchange, routingKey, gson.toJson(msg));
		System.out.println("MQ>> sending car brand "+ msg);
	}

	public void produceCarModel(CarModelMQ msg){
		amqpTemplate.convertAndSend(exchange, routingKey, gson.toJson(msg));
		System.out.println("MQ>> sending car model "+ msg);
	}

	public void produceCarClass(CarClassMQ msg){
		amqpTemplate.convertAndSend(exchange, routingKey, gson.toJson(msg));
		System.out.println("MQ>> sending car class "+ msg);
	}

	public void produceCarFuelType(CarFuelTypeMQ msg){
		amqpTemplate.convertAndSend(exchange, routingKey, gson.toJson(msg));
		System.out.println("MQ>> sending car fuel type "+ msg);
	}

	public void produceCarTransmission(CarTransmissionMQ msg){
		amqpTemplate.convertAndSend(exchange, routingKey, gson.toJson(msg));
		System.out.println("MQ>> sending car transmission "+ msg);
	}

	public void produceCar(CarMQ msg){
		amqpTemplate.convertAndSend(exchange, routingKey, gson.toJson(msg));
		System.out.println("MQ>> sending car "+ msg);
	}

	public void producePrice(PriceMQ msg){
		amqpTemplate.convertAndSend(exchange, routingKey, gson.toJson(msg));
		System.out.println("MQ>> sending price "+ msg);
	}

	public void producePicture(PictureMQ msg){
		amqpTemplate.convertAndSend(exchange, routingKey, gson.toJson(msg));
		System.out.println("MQ>> sending picture ");
	}

	public void produceCapture(CaptureMQ msg){
		amqpTemplate.convertAndSend(exchange, routingKey, gson.toJson(msg));
		System.out.println("MQ>> sending capture ");
	}

	public void produceAdvert(AdvertMQ msg){
		amqpTemplate.convertAndSend(exchange, routingKey, gson.toJson(msg));
		System.out.println("MQ>> sending advert ");
	}
}
