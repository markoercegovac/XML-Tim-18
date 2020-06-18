package com.example.request.comon;

import java.util.Set;
import java.util.HashSet;
import java.util.List;

import com.example.request.model.AdvertStateEnum;
import com.example.request.model.Request;
import com.example.request.model.RequestBundle;
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

	private final RequestBundleRepository bundleRepository;
	private final RequestRepository requestRepository;

	@After(value = "execution(* com.example.request.service.impl.OwnerServiceImpl.approvBundle(..)) and args(bundleId)")
	public void cancelAllOtherRequests(JoinPoint joinPoint, Long bundleId) {

		RequestBundle bundle = bundleRepository.getOne(bundleId);
		Set<Long> bundleIdsForCanceling = new HashSet<Long>();
		bundle.getRequests().forEach(request -> {

			List<Request> foundRequests = requestRepository.findAllByAdvertIdAndDatesBetween(
				request.getAdvertCopy().getAdvertCopyId(),
				request.getStartReservationDate(),
				request.getEndReservationDate()).orElse(null);

			if(foundRequests != null && !foundRequests.isEmpty()) {
				foundRequests.forEach(cancelRequest -> {
					bundleIdsForCanceling.add(cancelRequest.getRequestBundle().getRequestBundleId());
				});
			}
		});

		if(!bundleIdsForCanceling.isEmpty()) {
			bundleIdsForCanceling.forEach(cancelBundleId -> {
				
				RequestBundle canceldBundle = bundleRepository.getOne(cancelBundleId);
				canceldBundle.setAdvertState(AdvertStateEnum.CANCEL);
				bundleRepository.save(canceldBundle);
			});
		}

	}
}