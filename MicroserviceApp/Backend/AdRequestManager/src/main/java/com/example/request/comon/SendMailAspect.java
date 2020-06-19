package com.example.request.comon;

import com.example.request.model.AdvertStateEnum;
import com.example.request.model.MailMessage;
import com.example.request.model.RequestBundle;
import com.example.request.repository.RequestBundleRepository;
import com.google.gson.Gson;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SendMailAspect {
	
	@Autowired
	private RequestBundleRepository bundleRepository;

	@Autowired
	private Gson gson;

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${jsa.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${jsa.rabbitmq.routingkey}")
	private String routingKey;

	@After(value = "execution(* com.example.request.comon.ChangeState.change(..)) and args(bundleId, state)")
	public void sendMailChangeRequestStatus(JoinPoint joinPoint, Long bundleId, AdvertStateEnum state ) {

		RequestBundle bundle = bundleRepository.getOne(bundleId);
		MailMessage mail = new MailMessage(
			bundle.getRequestingUserEmail(),
			"",
			"");

		amqpTemplate.convertAndSend(exchange, routingKey, gson.toJson(mail));

	}
}