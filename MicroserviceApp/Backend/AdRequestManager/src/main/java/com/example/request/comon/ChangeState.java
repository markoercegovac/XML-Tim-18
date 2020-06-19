package com.example.request.comon;

import com.example.request.model.AdvertStateEnum;
import com.example.request.model.RequestBundle;
import com.example.request.repository.RequestBundleRepository;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ChangeState {
	
	private final RequestBundleRepository bundleRepository;

	public void change(Long bundleId, AdvertStateEnum state) {
		RequestBundle bundle = bundleRepository.getOne(bundleId);
		bundle.setAdvertState(state);
		bundleRepository.save(bundle);
	}

}