package com.team18.WebServiceManager.mq.service.producer;

import com.google.gson.Gson;
import com.team18.WebServiceManager.mq.dto.*;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
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
		try {
			String ms = "CarBrand-";
			ms += gson.toJson(msg);
			amqpTemplate.convertAndSend(exchange, routingKey, ms);
			System.out.println("MQ>> sending car brand " + msg);
		} catch (Exception e) {
			throw new AmqpRejectAndDontRequeueException(e.getMessage());
		}
	}

	public void produceCarModel(CarModelMQ msg){
		try {
			String ms = "CarModel-";
			ms += gson.toJson(msg);
			amqpTemplate.convertAndSend(exchange, routingKey, ms);
			System.out.println("MQ>> sending car model " + msg);
		} catch (Exception e) {
			throw new AmqpRejectAndDontRequeueException(e.getMessage());
		}
	}

	public void produceCarClass(CarClassMQ msg){
		try {
			String ms = "CarClass-";
			ms += gson.toJson(msg);
			amqpTemplate.convertAndSend(exchange, routingKey, ms);
			System.out.println("MQ>> sending car class " + msg);
		} catch (Exception e) {
			throw new AmqpRejectAndDontRequeueException(e.getMessage());
		}
	}

	public void produceCarFuelType(CarFuelTypeMQ msg){
		try {
			String ms = "CarFuelType-";
			ms += gson.toJson(msg);
			amqpTemplate.convertAndSend(exchange, routingKey, ms);
			System.out.println("MQ>> sending car fuel type " + msg);
		}catch (Exception e) {
			throw new AmqpRejectAndDontRequeueException(e.getMessage());
		}
	}

	public void produceCarTransmission(CarTransmissionMQ msg){
		try {
			String ms = "CarTransmission-";
			ms += gson.toJson(msg);
			amqpTemplate.convertAndSend(exchange, routingKey, ms);
			System.out.println("MQ>> sending car transmission " + msg);
		} catch (Exception e) {
			throw new AmqpRejectAndDontRequeueException(e.getMessage());
		}
	}

	public void produceCar(CarMQ msg){
		try {
			String ms = "Car-";
			ms += gson.toJson(msg);
			amqpTemplate.convertAndSend(exchange, routingKey, ms);
			System.out.println("MQ>> sending car " + msg);
		} catch (Exception e) {
			throw new AmqpRejectAndDontRequeueException(e.getMessage());
		}
	}

	public void producePrice(PriceMQ msg){
		try {
			String ms = "Price-";
			ms += gson.toJson(msg);
			amqpTemplate.convertAndSend(exchange, routingKey, ms);
			;
			System.out.println("MQ>> sending price " + msg);
		} catch (Exception e) {
			throw new AmqpRejectAndDontRequeueException(e.getMessage());
		}
	}

	public void producePicture(PictureMQ msg){
		try {
			String ms = "Picture-";
			ms += gson.toJson(msg);
			amqpTemplate.convertAndSend(exchange, routingKey, ms);
			System.out.println("MQ>> sending picture ");
		} catch (Exception e) {
			throw new AmqpRejectAndDontRequeueException(e.getMessage());
		}
	}

	public void produceCapture(CaptureMQ msg){
		try {
			String ms = "Capture-";
			ms += gson.toJson(msg);
			amqpTemplate.convertAndSend(exchange, routingKey, ms);
			System.out.println("MQ>> sending capture ");
		} catch (Exception e) {
			throw new AmqpRejectAndDontRequeueException(e.getMessage());
		}
	}

	public void produceAdvert(AdvertMQ msg){
		try {
			String ms = "Advert-";
			ms += gson.toJson(msg);
			amqpTemplate.convertAndSend(exchange, routingKey, ms);
			System.out.println("MQ>> sending advert ");
		} catch (Exception e) {
			throw new AmqpRejectAndDontRequeueException(e.getMessage());
		}
	}

	public void produceDriveReport(DriveReportMQ msg){
		try {
			String ms = "DriveReport-";
			ms += gson.toJson(msg);
			amqpTemplate.convertAndSend(exchange, routingKey, ms);
			System.out.println("MQ>> sending drive report ");
		} catch (Exception e) {
			throw new AmqpRejectAndDontRequeueException(e.getMessage());
		}
	}
}
