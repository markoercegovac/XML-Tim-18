package com.user.manager.aspect;


import com.user.manager.dto.AgentDTO;
import com.user.manager.mq.dto.Mail;
import com.user.manager.mq.service.MailProducer;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SendMailAspect {
	
	@Autowired
	private MailProducer mail;

	@After(value = "execution(* com.user.manager.services.impl.AgentRegistrationServiceImpl.register(..)) and args(dto)")
	public void sendMailAgentRegistered(JoinPoint joinPoint, AgentDTO dto) {

		Mail msg = new Mail();

		try {
			mail.produceMsg(msg);
		} catch(Exception e) {
			System.out.println("MQ NOT RUNNING");
		}
	}
}