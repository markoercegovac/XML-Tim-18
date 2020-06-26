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

		UserMail user = (UserMail) gson.fromJson(msg, UserMail.class);

		if(user.getUserEmail().isEmpty()) {
			String content = "Dear " + user.getCompanyName()
				+ ", You have successfully sign in to RENT IT application. Your token for DataBase synchronisation is: "
				+ user.getToken()
				+ " .";

			mailSender.send(user.getCompanyName(), "RENT IT REQISTRATION", content);
		} else {
			String content = "Dear " + user.getUserEmail()
				+ ", You have successfully sign in to RENT IT application.";

			mailSender.send(user.getUserEmail(), "RENT IT REQISTRATION", content);
		}
	}
}