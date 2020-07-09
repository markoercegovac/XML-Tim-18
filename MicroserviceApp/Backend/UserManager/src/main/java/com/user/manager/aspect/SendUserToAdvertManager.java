package com.user.manager.aspect;

import com.user.manager.dto.AgentDTO;
import com.user.manager.model.User;
import com.user.manager.mq.dto.UserMQ;
import com.user.manager.mq.service.AdvertProducer;

import com.user.manager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
@RequiredArgsConstructor
public class SendUserToAdvertManager {
	
	private final AdvertProducer advertProducer;

	@After(value = "execution(* com.user.manager.services.impl.AdminRegistrationServiceImpl.accept(..)) and args(email)")
	public void sendToAdvertWhenClientAdded(JoinPoint joinPoint, String email) {
		try {
			UserMQ msg = new UserMQ();
			msg.setEmail(email);
			msg.setBanned(false);
			msg.setCreationEnabled(true);
			msg.setForbiddenAdvert(false);
			msg.setRemoved(false);

			advertProducer.produceMsg(msg);
		}catch (Exception e) {
			System.out.println("MQ NOT AVAILABLE");
		}
	}

	@After(value = "execution(* com.user.manager.services.impl.UserServiceImplementation.deleteUser(..)) and args(user)")
	public void sendToAdvertWhenClientRemoved(JoinPoint joinPoint, User user) {
		try {
			UserMQ msg = new UserMQ();
			msg.setEmail(user.getEmail());
			msg.setBanned(user.isBanned());
			msg.setCreationEnabled(true);
			msg.setForbiddenAdvert(user.isForbiddenAdvert());
			msg.setRemoved(user.isRemoved());

		}catch (Exception e) {
			System.out.println("MQ NOT AVAILABLE");
		}
	}
}