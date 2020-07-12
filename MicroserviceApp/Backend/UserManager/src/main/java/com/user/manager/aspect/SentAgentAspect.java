package com.user.manager.aspect;

import com.user.manager.model.User;
import com.user.manager.mq.dto.AgentMQ;
import com.user.manager.mq.dto.Mail;
import com.user.manager.mq.service.AgentProducer;
import com.user.manager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@RequiredArgsConstructor
public class SentAgentAspect {

	private final AgentProducer mqProducer;
	private final UserRepository users;

	@AfterReturning(value = "execution(* com.user.manager.services.impl.AdminRegistrationServiceImpl.accept(..))", returning = "user")
	public void sendMailAgentRegistered(JoinPoint joinPoint, User user) {

		try {
			if(user.getAgentUrl()!=null && !user.getAgentUrl().isEmpty()) {
				AgentMQ msg = new AgentMQ();
				msg.setEmail(user.getEmail());
				msg.setUrl(user.getAgentUrl());

				mqProducer.produceMsg(msg);
			}

		} catch(Exception e) {
			System.out.println("MQ NOT RUNNING");
		}
	}
}
