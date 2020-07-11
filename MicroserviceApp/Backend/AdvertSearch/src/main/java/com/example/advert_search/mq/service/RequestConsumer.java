package com.example.advert_search.mq.service;

import com.example.advert_search.model.AdvertCopy;
import com.example.advert_search.model.CarReservedDate;
import com.example.advert_search.mq.dto.ReservedCarSearchMQ;
import com.example.advert_search.repository.CarReservedDateRepository;
import com.example.advert_search.repository.SearchRepository;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RequestConsumer {

	@Autowired
	private Gson gson;
	@Autowired
	private CarReservedDateRepository carReservedDateRepository;
	@Autowired
	private SearchRepository advertRepository;

	@RabbitListener(queues="${rabbitmq.queue.from.request}")
	public void recievedMessage(String msg) {
		System.out.println("MQ>>Recieved Message from ad request: " + msg);

		try {
			ReservedCarSearchMQ recived = gson.fromJson(msg, ReservedCarSearchMQ.class);
			AdvertCopy a = advertRepository.findByAdvertCopyId(recived.getAdId());

			CarReservedDate carReservedDate = new CarReservedDate();
			carReservedDate.setStartOfAdvert(recived.getStart());
			carReservedDate.setEndOfAdvert(recived.getEnd());

			if(a.getCarReservedDate() == null) {
				List<CarReservedDate> l = new ArrayList<>();
				l.add(carReservedDate);
				a.setCarReservedDate(l);
			} else {
				a.getCarReservedDate().add(carReservedDate);
			}

			carReservedDateRepository.save(carReservedDate);
			advertRepository.save(a);
		} catch(Exception e) {
			System.out.println("MQ ERROR");
		}
	}
}
