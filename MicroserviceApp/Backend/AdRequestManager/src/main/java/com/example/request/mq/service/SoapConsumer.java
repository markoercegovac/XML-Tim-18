package com.example.request.mq.service;

import com.example.request.model.*;
import com.example.request.mq.dto.AdRequestMQ;
import com.example.request.mq.dto.ReservationMQ;
import com.example.request.repository.AdvertCopyRepository;
import com.example.request.repository.RequestBundleRepository;
import com.example.request.repository.RequestRepository;
import com.google.gson.Gson;
import com.netflix.discovery.converters.Auto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component
public class SoapConsumer {

	@Autowired
	private Gson gson;
	@Autowired
	private RequestRepository requestRepository;
	@Autowired
	private RequestBundleRepository requestBundleRepository;
	@Autowired
	private AdvertCopyRepository advertCopyRepository;

	@RabbitListener(queues="${rabbitmq.queue.soap}")
	public void recievedMessage(String msg) {
		System.out.println("MQ>> Got from soap" +msg);

		try {
			ReservationMQ mq = gson.fromJson(msg, ReservationMQ.class);
			Request request = requestRepository.findById(mq.getId()).orElse(null);
			if( request == null) {
				request = new Request();
				request.setEndReservationDate(mq.getEnd());
				request.setStartReservationDate(mq.getStart());
				List<Request> l = new ArrayList<>();
				l.add(request);

				AdvertCopy ad = advertCopyRepository.findByRequestsRequestId(mq.getAdvertId()).orElse(null);
				if(ad != null) {
					ad = new AdvertCopy();
					ad.setRequests(l);
				} else {
					ad.getRequests().addAll(l);
				}


				RequestBundle b = new RequestBundle();
				b.setPriceWithDiscount(230);
				b.setAdvertState(AdvertStateEnum.valueOf(mq.getStatus()));
				b.setRequests(l);
				b.setOwnerEmail(mq.getOwnerEmail());
				b.setRequestingUserEmail(mq.getUserEmail());

				requestRepository.save(request);
				advertCopyRepository.save(ad);
				requestBundleRepository.save(b);
			}



		} catch(Exception e) {
			System.out.println("MQ>> EXCEPTION");
		}
	}
}
