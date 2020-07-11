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

	@Value("${rabbitmq.direct.soap.soap.ad}")
	private String exchange;

	@Value("${rabbitmq.key.soap.soap.ad}")
	private String routingKey;

	public void produceCarBrand(CarBrandMQ msg){
		String ms = "CarBrand-";
		ms += gson.toJson(msg);
		amqpTemplate.convertAndSend(exchange, routingKey, ms);
		System.out.println("MQ>> sending car brand "+ msg);
	}

	public void produceCarModel(CarModelMQ msg){
		String ms = "CarModel-";
		ms += gson.toJson(msg);
		amqpTemplate.convertAndSend(exchange, routingKey, ms);
		System.out.println("MQ>> sending car model "+ msg);
	}

	public void produceCarClass(CarClassMQ msg){
		String ms = "CarClass-";
		ms += gson.toJson(msg);
		amqpTemplate.convertAndSend(exchange, routingKey, ms);
		System.out.println("MQ>> sending car class "+ msg);
	}

	public void produceCarFuelType(CarFuelTypeMQ msg){
		String ms = "CarFuelType-";
		ms += gson.toJson(msg);
		amqpTemplate.convertAndSend(exchange, routingKey, ms);
		System.out.println("MQ>> sending car fuel type "+ msg);
	}

	public void produceCarTransmission(CarTransmissionMQ msg){
		String ms = "CarTransmission-";
		ms += gson.toJson(msg);
		amqpTemplate.convertAndSend(exchange, routingKey, ms);
		System.out.println("MQ>> sending car transmission "+ msg);
	}

	public void produceCar(CarMQ msg){
		String ms = "Car-";
		ms += gson.toJson(msg);
		amqpTemplate.convertAndSend(exchange, routingKey, ms);
		System.out.println("MQ>> sending car "+ msg);
	}

	public void producePrice(PriceMQ msg){
		String ms = "Price-";
		ms += gson.toJson(msg);
		amqpTemplate.convertAndSend(exchange, routingKey, ms);;
		System.out.println("MQ>> sending price "+ msg);
	}

	public void producePicture(PictureMQ msg){
		String ms = "Picture-";
		ms += gson.toJson(msg);
		amqpTemplate.convertAndSend(exchange, routingKey, ms);
		System.out.println("MQ>> sending picture ");
	}

	public void produceCapture(CaptureMQ msg){
		String ms = "Capture-";
		ms += gson.toJson(msg);
		amqpTemplate.convertAndSend(exchange, routingKey, ms);
		System.out.println("MQ>> sending capture ");
	}

	public void produceAdvert(AdvertMQ msg){
		String ms = "Advert-";
		ms += gson.toJson(msg);
		amqpTemplate.convertAndSend(exchange, routingKey, ms);
		System.out.println("MQ>> sending advert ");
	}
}
