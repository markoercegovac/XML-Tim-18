package com.user.manager.aspect;

import com.user.manager.comon.MailProducer;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SendMailAspect {
	
	@Autowired
	private MailProducer mail;

	// @After(value = "execution(* chat.service.impl.SendMessageServiceImpl.send(..)) and args(sendMessage)")
	public void sendMail() {

		// mail.produceMsg(msg);
	}
}