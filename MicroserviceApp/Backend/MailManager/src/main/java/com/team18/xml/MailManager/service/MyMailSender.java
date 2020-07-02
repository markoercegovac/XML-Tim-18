package com.team18.xml.MailManager.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyMailSender {

	@Value("${spring.mail.username}")
	private String username;
	@Value("${spring.mail.password}")
	private String password;
	@Value("${spring.mail.host}")
	private String host;
	@Value("${spring.mail.port}")
	private String port;

	public void send(String receiver, String header, String content) {

        Properties properties=new Properties();
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		
		Session session=Session.getInstance(properties,new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
		});
		
        try {
            Message message=new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(receiver));


			content += "\n\nThis message is auto generated.\nBest regards,\nRENT IT application";
            message.setSubject(header);
            message.setContent(content,"text/html; charset=utf-8");
            message.setText(content);


            Transport.send(message);

        }catch(MessagingException e) {
            throw new RuntimeException(e);
        }
	}
}