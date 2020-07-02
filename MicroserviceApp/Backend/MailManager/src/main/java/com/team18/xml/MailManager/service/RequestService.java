package com.team18.xml.MailManager.service;

import com.google.gson.Gson;
import com.team18.xml.MailManager.model.RequestMail;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestService {
	
	@Autowired
	private MyMailSender mailSender;
	@Autowired
	private Gson gson;

	@RabbitListener(queues="${rabbitmq.queue.from.request}")
	public void received(String msg) {

		RequestMail request = (RequestMail) gson.fromJson(msg, RequestMail.class);
		
		if(!request.getBundleStatus().equals("PENDING")) {
			String contentForUser = "Dear sir or madam,\nYoure requesting advert bundle has change state to ";
			contentForUser +=  request.getBundleStatus()+ ".";
	
			mailSender.send(request.getUserEmail(), "ADVERT BUNDLE CHANGED STATUS", contentForUser);
		} else {
			String contentForOwner = "Dear sir or madam,\nYou have new advert request. Sign in to view request.";

			mailSender.send(request.getOwnerEmail(), "NEW REQUEST", contentForOwner);
		}

	}
}