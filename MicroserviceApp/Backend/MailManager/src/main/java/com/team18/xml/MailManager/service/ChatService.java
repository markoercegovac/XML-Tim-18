package com.team18.xml.MailManager.service;

import com.google.gson.Gson;
import com.team18.xml.MailManager.model.ChatMail;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChatService {

	@Autowired
	private MyMailSender mailSender;
	@Autowired
	private Gson gson;

	@RabbitListener(queues="${rabbitmq.queue.from.chat}")
	public void received(String msg) {

		try {
			ChatMail chat = (ChatMail) gson.fromJson(msg, ChatMail.class);
			String content = "Dear sir or madam,\nYou have a new message from " + chat.getSender();
			content += ".\nSign in to replay.\nMessage content:";
			content += chat.getContent();

			mailSender.send(chat.getReceiver(), chat.getHeader(), content);
		} catch (Exception e) {}
	}
}