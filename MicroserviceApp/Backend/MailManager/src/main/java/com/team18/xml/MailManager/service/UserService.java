package com.team18.xml.MailManager.service;

import com.google.gson.Gson;
import com.team18.xml.MailManager.model.UserMail;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
	
	@Autowired
	private MyMailSender mailSender;
	@Autowired
	private Gson gson;

	@RabbitListener(queues="${rabbitmq.queue.from.user}")
	public void received(String msg) {

		try {
			UserMail user = (UserMail) gson.fromJson(msg, UserMail.class);

			String content;
			if (user.getCompanyName() == null || user.getCompanyName().isEmpty()) {
				//imamo obicnog korisnika
				content = "Dear " + user.getName() + " " + user.getSurname()
						+ ", You have successfully sign in to RENT IT application.";
			} else if (user.isAgent()) {
				content = "Dear " + user.getCompanyName()
						+ ", You have successfully sign in to RENT IT application. Your can download WSDL from http://rent-a-car/ws/team18-agent.wsdl .";
			} else {
				content = "Dear " + user.getCompanyName()
						+ ", You have successfully sign in to RENT IT application.";
			}

			mailSender.send(user.getEmail(), "RENT IT REGISTRATION", content);
		} catch (Exception e) {}
	}
}