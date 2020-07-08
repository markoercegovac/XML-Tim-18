package com.user.manager.aspect;

import com.user.manager.dto.AgentDTO;
import com.user.manager.mq.service.AdvertProducer;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SendUserToAdvertManager {
	
	@Autowired
	private AdvertProducer advertProducer;

	@After(value = "execution(* com.user.manager.services.impl.AgentRegistrationServiceImpl.register(..)) and args(dto)")
	public void sendToAdvertWhenAgentRegistered(JoinPoint joinPoint, AgentDTO dto) {
		
	}
}