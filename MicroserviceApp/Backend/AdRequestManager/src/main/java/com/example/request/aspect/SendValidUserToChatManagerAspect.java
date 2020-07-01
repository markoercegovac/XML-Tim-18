package com.example.request.aspect;

import com.example.request.model.RequestBundle;
import com.example.request.mq.dto.ChatMQ;
import com.example.request.mq.service.ChatProducer;
import com.example.request.repository.RequestBundleRepository;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SendValidUserToChatManagerAspect {
	
	@Autowired
	private ChatProducer chatProducer;
	@Autowired
	private RequestBundleRepository bundleRepo;

	@After(value = "execution(* com.example.request.service.impl.OwnerServiceImpl.approveBundle(..)) and args(bundleId)")
	public void sendMailChangeRequestStatus(JoinPoint joinPoint, Long bundleId ) {
		try {
			
			RequestBundle b = bundleRepo.findById(bundleId).orElseThrow(NullPointerException::new);
			ChatMQ mq = new ChatMQ(
				b.getRequestingUserEmail(),
				b.getOwnerEmail(), 
				false);

				chatProducer.send(mq);
		} catch(Exception e) {
			System.out.println("ASPECT EXCEPTION");
		}
	}
}