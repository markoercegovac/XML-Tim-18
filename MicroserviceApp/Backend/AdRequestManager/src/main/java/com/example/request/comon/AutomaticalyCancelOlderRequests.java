package com.example.request.comon;


import java.util.Calendar;
import java.util.List;

import com.example.request.model.AdvertStateEnum;
import com.example.request.model.RequestBundle;
import com.example.request.repository.RequestBundleRepository;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@Aspect
@RequiredArgsConstructor
public class AutomaticalyCancelOlderRequests {
	
	private final RequestBundleRepository requestBundle;

	@Before("execution(* com.example.request.service.impl.findOwnersAdByState(..)) && args(email, ..)")
	public void beforeOwnerSeeBundleRequests(JoinPoint joinPoint, String email) {

		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -1);
		List<RequestBundle> olderBundles = requestBundle.findAllByOwnerEmailAndCreationDateAndTimeBefore(email, c.getTime()).orElse(null);

		if(olderBundles != null && !olderBundles.isEmpty()) {
			olderBundles.forEach(bundle -> {
				bundle.setAdvertState(AdvertStateEnum.CANCEL);

				requestBundle.save(bundle);
			});
		}
	}
}