package com.example.request.service.impl;

import com.example.request.comon.ChangeState;
import com.example.request.model.AdvertStateEnum;
import com.example.request.repository.RequestBundleRepository;
import com.example.request.service.MainService;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MainServiceImpl implements MainService {

	private final ChangeState changeState;
	private final RequestBundleRepository bundleRepository;

	@Override
	public boolean cancelBundle(Long bundleId) {
	
		if(bundleId!= null && bundleRepository.getOne(bundleId) != null) {
			changeState.change(bundleId, AdvertStateEnum.CANCEL);

			return true;
		} else {
			return false;
		}
	}
	
}