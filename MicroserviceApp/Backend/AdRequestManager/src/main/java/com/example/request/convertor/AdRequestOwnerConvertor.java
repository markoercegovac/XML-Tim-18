package com.example.request.convertor;

import java.util.HashSet;
import java.util.Set;

import com.example.request.dto.AdRequestForOwnerDTO;
import com.example.request.model.RequestBundle;

public abstract class AdRequestOwnerConvertor {
	
	public static AdRequestForOwnerDTO fromBundleToAdRequestForOwner(RequestBundle bundle) throws NullPointerException {
		
		AdRequestForOwnerDTO dto = new AdRequestForOwnerDTO();
		dto.setPriceWithDiscount(bundle.getPriceWithDiscount());
		dto.setRequestBundleId(bundle.getRequestBundleId());
		dto.setRequestingUserEmail(bundle.getOwnerEmail());
		dto.setStatus(bundle.getAdvertState().toString());

		Set<Long> adIds = new HashSet<Long>();
		bundle.getRequests().forEach(request -> {
			adIds.add(request.getAdvertCopy().getAdvertCopyId());
		});

		return dto;
	}
}