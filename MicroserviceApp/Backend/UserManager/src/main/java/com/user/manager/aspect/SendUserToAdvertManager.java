package com.user.manager.aspect;

import com.user.manager.mq.service.AdvertProducer;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SendUserToAdvertManager {
	
	@Autowired
	private AdvertProducer advertProducer;

	public void sendToAdvert() {
		
	}
}