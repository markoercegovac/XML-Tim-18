package com.example.request.aspect;

import com.example.request.dto.CreateAdBundleRequestDTO;
import com.example.request.model.AdvertStateEnum;
import com.example.request.model.RequestBundle;
import com.example.request.mq.dto.MailMessage;
import com.example.request.mq.service.MailProducer;
import com.example.request.repository.RequestBundleRepository;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SendMailAspect {

	@Autowired
	private RequestBundleRepository bundleRepository;
	@Autowired
	private MailProducer mailProducer;

	@After(value = "execution(* com.example.request.comon.ChangeState.change(..)) and args(bundleId, state)")
	public void sendMailChangeRequestStatus(JoinPoint joinPoint, Long bundleId, AdvertStateEnum state ) {
		/**
		 * Send mail to user requested bundle that the state has changed
		 */

		try {
			RequestBundle bundle = bundleRepository.getOne(bundleId);
			MailMessage mail = new MailMessage(
					bundle.getRequestingUserEmail(),
					"ADVERT REQUEST HAS CHANGE STATE",
					"Your advert request bundle for has change state to:"+bundle.getAdvertState()+"." );

			mailProducer.sendMail(mail);
		} catch(Exception e) {
			System.out.println("NO QUEUE");
		}
	}

	@After(value = "execution(* com.example.request.service.impl.OwnerServiceImpl.approveBundle(..)) and args(bundleId)")
	public void sendMailThatRequestHasBeenApproved(JoinPoint joinPoint, Long bundleId) {
		/**
		 * Send mail to user requested bundle has been approved
		 */

		try {
			RequestBundle bundle = bundleRepository.getOne(bundleId);
			MailMessage mail = new MailMessage(
					bundle.getRequestingUserEmail(),
					"ADVERT REQUEST HAS CHANGE STATE",
					"Your advert request bundle for has been approved.");

			mailProducer.sendMail(mail);
		} catch(Exception e) {
			System.out.println("NO QUEUE");
		}
	}

	@After(value = "execution(* com.example.request.service.impl.ClientRequestServiceImpl.createNewRequestBundle(..)) and args(createBundle)")
	public void sendMailNewRequestHasBeenCreated(JoinPoint joinPoint, CreateAdBundleRequestDTO createBundle) {
		/**
		 * Send mail to owner that new request has been made
		 */
		try {
			MailMessage mail = new MailMessage(
					createBundle.getAdvertOwnerEmail(),
					"CREATED NEW AD REQUEST",
					"New advert request has been created.");

			mailProducer.sendMail(mail);
		} catch(Exception e) {
			System.out.println("NO QUEUE");
		}
	}
}