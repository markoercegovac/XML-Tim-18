package com.example.request.aspect;

import com.example.request.dto.CreateAdBundleRequestDTO;
import com.example.request.model.AdvertCopy;
import com.example.request.model.AdvertStateEnum;
import com.example.request.model.Request;
import com.example.request.model.RequestBundle;
import com.example.request.mq.dto.MailMessage;
import com.example.request.mq.dto.ReservationMQ;
import com.example.request.mq.service.SoapProducer;
import com.example.request.repository.AdvertCopyRepository;
import com.example.request.repository.RequestBundleRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SoapAspect {

	@Autowired
	private RequestBundleRepository bundleRepository;
	@Autowired
	private SoapProducer soapProducer;
	@Autowired
	private AdvertCopyRepository advertCopyRepository;

	@After(value = "execution(* com.example.request.comon.ChangeState.change(..)) and args(bundleId, state)")
	public void sendSoapRequestChangeState(JoinPoint joinPoint, Long bundleId, AdvertStateEnum state ) {
		/**
		 * Send mail to user requested bundle that the state has changed
		 */

		try {
			RequestBundle bundle = bundleRepository.getOne(bundleId);
			ReservationMQ mq = new ReservationMQ();

			bundle.getRequests().forEach(r -> {
				AdvertCopy a = advertCopyRepository.findByRequestsRequestId(r.getRequestId()).orElse(null);
				mq.setAdvertId(a!=null?a.getAdvertCopyId():0);
				mq.setEnd(r.getEndReservationDate());
				mq.setStart(r.getStartReservationDate());
				mq.setStatus(bundle.getAdvertState().toString());
				mq.setId(r.getRequestId());
				mq.setOwnerEmail("firm@com");
				mq.setUserEmail(bundle.getRequestingUserEmail());
			});

			soapProducer.sendSoap(mq);
		} catch(Exception e) {
			System.out.println("NO QUEUE");
		}
	}

	@After(value = "execution(* com.example.request.service.impl.OwnerServiceImpl.approveBundle(..)) and args(bundleId)")
	public void sendSoapRequestBeenApproved(JoinPoint joinPoint, Long bundleId) {
		try {
			RequestBundle bundle = bundleRepository.getOne(bundleId);
			ReservationMQ mq = new ReservationMQ();

			bundle.getRequests().forEach(r -> {
				AdvertCopy a = advertCopyRepository.findByRequestsRequestId(r.getRequestId()).orElse(null);
				mq.setAdvertId(a!=null?a.getAdvertCopyId():0);
				mq.setEnd(r.getEndReservationDate());
				mq.setStart(r.getStartReservationDate());
				mq.setStatus(bundle.getAdvertState().toString());
				mq.setId(r.getRequestId());
				mq.setOwnerEmail("firm@com");
				mq.setUserEmail(bundle.getRequestingUserEmail());
			});

			soapProducer.sendSoap(mq);
		} catch(Exception e) {
			System.out.println("NO QUEUE");
		}
	}

	@AfterReturning(value = "execution(* com.example.request.service.impl.ClientRequestServiceImpl.createNewRequestBundle(..))", returning = "bundle")
	public void sendSoapNewRequestHasBeenCreated(JoinPoint joinPoint, RequestBundle bundle) {

		try {
			ReservationMQ mq = new ReservationMQ();

			bundle.getRequests().forEach(r -> {
				AdvertCopy a = advertCopyRepository.findByRequestsRequestId(r.getRequestId()).orElse(null);
				mq.setAdvertId(a != null ? a.getAdvertCopyId() : 0);
				mq.setEnd(r.getEndReservationDate());
				mq.setStart(r.getStartReservationDate());
				mq.setStatus(bundle.getAdvertState().toString());
				mq.setId(r.getRequestId());
				mq.setOwnerEmail("firm@com");
				mq.setUserEmail(bundle.getRequestingUserEmail());

				soapProducer.sendSoap(mq);
			});
		} catch(Exception e) {
			System.out.println("NO QUEUE");
		}
	}
}

