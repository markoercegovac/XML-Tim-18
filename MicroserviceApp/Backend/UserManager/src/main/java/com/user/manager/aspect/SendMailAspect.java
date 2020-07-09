package com.user.manager.aspect;


import com.user.manager.model.User;
import com.user.manager.mq.dto.Mail;
import com.user.manager.mq.service.MailProducer;

import com.user.manager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@RequiredArgsConstructor
public class SendMailAspect {

	private final MailProducer mail;
	private final UserRepository users;

	@After(value = "execution(* com.user.manager.services.impl.AdminRegistrationServiceImpl.accept(..)) and args(email)")
	public void sendMailAgentRegistered(JoinPoint joinPoint, String email) {

		try {
			Mail msg = new Mail();
			User u = users.getOne(email);
			msg.setEmail(email);
			msg.setName(u.getName());
			msg.setSurname(u.getSurname());
			msg.setCompanyName(u.getCompanyName());
			msg.setAgent(!u.getUsername().isEmpty());

			mail.produceMsg(msg);
		} catch(Exception e) {
			System.out.println("MQ NOT RUNNING");
		}
	}
}