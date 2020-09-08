package com.example.request.aspect;

import com.example.request.model.RequestBundle;
import com.example.request.mq.dto.ReservedCarSearchMQ;
import com.example.request.mq.service.SearchProducer;
import com.example.request.repository.AdvertCopyRepository;
import com.example.request.repository.RequestBundleRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
@RequiredArgsConstructor
public class SearchAspect {

	@Autowired
	private SearchProducer searchProducer;
	@Autowired
	private RequestBundleRepository requestBundleRepository;
	@Autowired
	private AdvertCopyRepository advertCopyRepository;

	@After(value = "execution(* com.example.request.service.impl.OwnerServiceImpl.approveBundle(..)) and args(bundleId)")
	public void sendSearchThatRequestHasBeenApproved(JoinPoint joinPoint, Long bundleId) {

		try {
			RequestBundle bundle = requestBundleRepository.getOne(bundleId);
			bundle.getRequests().forEach(r -> {
				ReservedCarSearchMQ mq = new ReservedCarSearchMQ();
				mq.setAdId(advertCopyRepository.findByRequestsRequestId(r.getRequestId()).get().getAdvertCopyId());
				mq.setEnd(r.getEndReservationDate());
				mq.setStart(r.getStartReservationDate());

				searchProducer.sendSearch(mq);
			});
		} catch(Exception e) {
			System.out.println("NO QUEUE");
		}
	}
}
