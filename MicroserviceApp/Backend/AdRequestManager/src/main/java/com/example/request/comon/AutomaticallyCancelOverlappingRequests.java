package com.example.request.comon;

import java.util.List;

import com.example.request.model.AdvertCopy;
import com.example.request.model.AdvertStateEnum;
import com.example.request.model.Request;
import com.example.request.model.RequestBundle;
import com.example.request.repository.AdvertCopyRepository;
import com.example.request.repository.RequestBundleRepository;
import com.example.request.repository.RequestRepository;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

@Component
@Aspect
@RequiredArgsConstructor
public class AutomaticallyCancelOverlappingRequests {

	private final ChangeState changeState;
	private final RequestBundleRepository bundleRepository;
	private final RequestRepository requestRepository;
	private final AdvertCopyRepository advertRepository;

	@After(value = "execution(* com.example.request.service.impl.OwnerServiceImpl.approveBundle(..)) and args(bundleId)")
	public void cancelAllOtherRequests(JoinPoint joinPoint, Long bundleId) {

		RequestBundle bundle = bundleRepository.getOne(bundleId);
		bundle.getRequests().forEach(request -> {

			AdvertCopy a = advertRepository.findByRequestsRequestId(request.getRequestId()).orElse(null);
			if(a == null) {
				return;
			}

			List<Request> foundRequests = requestRepository.findAllByAdvertIdAndDatesBetween(
				a.getAdvertCopyId(),
				request.getStartReservationDate(),
				request.getEndReservationDate()).orElse(null);

			if(foundRequests != null && !foundRequests.isEmpty()) {
				foundRequests.forEach(cancelRequest -> {
					RequestBundle bun = bundleRepository.findByRequestsRequestId(cancelRequest.getRequestId()).orElse(null);
					if(bun != null) {
						changeState.change(bun.getRequestBundleId(), AdvertStateEnum.CANCEL);
					}
				});
			}
		});
	}
}