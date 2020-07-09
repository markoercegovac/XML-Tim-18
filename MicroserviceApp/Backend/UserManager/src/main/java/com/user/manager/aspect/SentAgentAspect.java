package com.user.manager.aspect;

import com.user.manager.model.User;
import com.user.manager.mq.dto.AgentMQ;
import com.user.manager.mq.dto.Mail;
import com.user.manager.mq.service.AgentProducer;
import com.user.manager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@RequiredArgsConstructor
public class SentAgentAspect {

	private final AgentProducer mqProducer;
	private final UserRepository users;

	@After(value = "execution(* com.user.manager.services.impl.AdminRegistrationServiceImpl.accept(..)) and args(email)")
	public void sendMailAgentRegistered(JoinPoint joinPoint, String email) {

		try {
			User u = users.getOne(email);
			if(u.getAgentUrl()!=null && !u.getAgentUrl().isEmpty()) {
				AgentMQ msg = new AgentMQ();
				msg.setEmail(email);
				msg.setUrl(u.getAgentUrl());

				mqProducer.produceMsg(msg);
			}

		} catch(Exception e) {
			System.out.println("MQ NOT RUNNING");
		}
	}
}
