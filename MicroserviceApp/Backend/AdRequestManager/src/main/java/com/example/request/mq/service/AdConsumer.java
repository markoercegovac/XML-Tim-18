package com.example.request.mq.service;

import java.util.HashSet;
import java.util.Set;

import com.example.request.model.AdvertCopy;
import com.example.request.model.CarReservedDate;
import com.example.request.mq.dto.AdRequestMQ;
import com.example.request.repository.AdvertCopyRepository;
import com.google.gson.Gson;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdConsumer {
	
	@Autowired
	private Gson gson;
	@Autowired
	private AdvertCopyRepository adRepo;

	@RabbitListener(queues="${rabbitmq.queue.from.advert}")
    public void recievedMessage(String msg) {
	    System.out.println("MQ>> Got from user manager" +msg);

		try {
			AdRequestMQ mq = gson.fromJson(msg, AdRequestMQ.class);
			
			Set<CarReservedDate> carReservedDate = new HashSet<>();
			mq.getCarReservedDate().forEach(res -> {
				CarReservedDate r = new CarReservedDate();
				r.setCarReservedDateId(res.getCarReservedDateId());
				r.setEndDate(res.getEndDate());
				r.setStartDate(res.getStartDate());

				carReservedDate.add(r);
			});

			AdvertCopy ad = new AdvertCopy();
			ad.setAdvertCopyId(mq.getAdvertCopyId());
			ad.setAdvertEndDate(mq.getAdvertEndDate());
			ad.setOwnerEmail(mq.getOwnerEmail());
			ad.setCarReservedDate(carReservedDate);

			adRepo.save(ad);
		} catch(Exception e) {
			System.out.println("MQ>> EXCEPTION");
		}
    }
}