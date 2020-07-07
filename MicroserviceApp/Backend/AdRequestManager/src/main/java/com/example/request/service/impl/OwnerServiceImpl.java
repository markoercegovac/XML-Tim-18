package com.example.request.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.example.request.convertor.AdRequestOwnerConverter;
import com.example.request.dto.AdRequestForOwnerDTO;
import com.example.request.model.AdvertStateEnum;
import com.example.request.model.RequestBundle;
import com.example.request.repository.RequestBundleRepository;
import com.example.request.service.OwnerService;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {
	
	private final RequestBundleRepository bundleRepository;
	private final AdRequestOwnerConverter adRequestOwnerConverter;

	@Override
	public void approveBundle(Long bundleId) throws Exception {
		RequestBundle bundle = bundleRepository.getOne(bundleId);

		Calendar c = Calendar.getInstance();
		bundle.setAdvertState(AdvertStateEnum.PAID);
		bundle.setApprovedDateAndTime(c.getTime());

		bundleRepository.save(bundle);
	}

	@Override
	public List<AdRequestForOwnerDTO> findOwnersAdByState(String email, AdvertStateEnum state) throws Exception {
		
		if(email == null || email.trim().isEmpty()) {
			throw new NullPointerException("NO EMAIL");
		}
		
		List<AdRequestForOwnerDTO> foundAdRequests = new ArrayList<>();
		if(state == null) {
			foundAdRequests = getAllRequestsForOwner(email);
		} else {
			foundAdRequests = getAllRequestsWithStatusForOwner(email, state);
		}

		return foundAdRequests;
	}
	
	private List<AdRequestForOwnerDTO> getAllRequestsForOwner(String email) {

		List<AdRequestForOwnerDTO> foundAdRequests = new ArrayList<>();
		List<RequestBundle> foundRequest = bundleRepository.findAllByOwnerEmail(email).orElse(null);

		if(foundRequest != null && !foundRequest.isEmpty()) {
			foundRequest.forEach(bundle -> {
				try {
					foundAdRequests.add(adRequestOwnerConverter.fromBundleToAdRequestForOwner(bundle));
				} catch(Exception e) {
					e.printStackTrace();
					System.out.println("DATA BASE IS NOT CONSISTENT");
				}
			});
		}

		return foundAdRequests;
	}

	private List<AdRequestForOwnerDTO> getAllRequestsWithStatusForOwner(String email, AdvertStateEnum status) {

		List<AdRequestForOwnerDTO> foundAdRequests = new ArrayList<>();
		List<RequestBundle> foundRequest = bundleRepository.findAllByOwnerEmailAndAdvertState(email, status).orElse(null);

		if(foundRequest != null && !foundRequest.isEmpty()) {
			foundRequest.forEach(bundle -> {
				try {
					foundAdRequests.add(adRequestOwnerConverter.fromBundleToAdRequestForOwner(bundle));
				} catch(NullPointerException e) {
					System.out.println("DATA BASE IS NOT CONSISTENT");
				}
			});
		}

		return foundAdRequests;
	}

}