package com.team18.xml.MailManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MyMailSender {

	@Autowired
	private JavaMailSender javaMailSender;

	public void send(String receiver, String header, String content) {

		content += "\n\nThis message is auto generated.\nBest regards,\nRENT IT application";

		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(receiver);
		msg.setSubject(header);
		msg.setText(content);
		msg.setFrom("rent-it@maildrop.cc");

		javaMailSender.send(msg);
	}
}