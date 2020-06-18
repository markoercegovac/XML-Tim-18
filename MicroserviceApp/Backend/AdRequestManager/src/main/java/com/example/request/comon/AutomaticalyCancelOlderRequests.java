package com.example.request.comon;


import java.util.Calendar;
import java.util.List;

import com.example.request.model.AdvertStateEnum;
import com.example.request.model.RequestBundle;
import com.example.request.repository.RequestBundleRepository;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@Aspect
public class AutomaticalyCancelOlderRequests {
	
	@Autowired
	private RequestBundleRepository requestBundle;

	@Before(value = "execution(* com.example.request.service.impl.OwnerServiceImpl.findOwnersAdByState(..)) and args(email, state)")
	public void beforeOwnerSeeBundleRequests(JoinPoint joinPoint, String email, AdvertStateEnum state) {

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