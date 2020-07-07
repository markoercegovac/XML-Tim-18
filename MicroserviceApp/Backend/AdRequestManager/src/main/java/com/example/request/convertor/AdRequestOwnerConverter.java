package com.example.request.convertor;

import java.util.HashSet;
import java.util.Set;


import com.example.request.dto.AdRequestDTO;
import com.example.request.dto.AdRequestForOwnerDTO;
import com.example.request.model.AdvertCopy;
import com.example.request.model.RequestBundle;
import com.example.request.repository.AdvertCopyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdRequestOwnerConverter {

	private final AdvertCopyRepository advertRepository;

	public AdRequestForOwnerDTO fromBundleToAdRequestForOwner(RequestBundle bundle) throws NullPointerException {
		
		AdRequestForOwnerDTO dto = new AdRequestForOwnerDTO();
		dto.setPriceWithDiscount(bundle.getPriceWithDiscount());
		dto.setRequestBundleId(bundle.getRequestBundleId());
		dto.setRequestingUserEmail(bundle.getOwnerEmail());
		dto.setStatus(bundle.getAdvertState().toString());

		Set<AdRequestDTO> requests = new HashSet<AdRequestDTO>();
		if(bundle.getRequests().size() != 0) {
			 bundle.getRequests().forEach(request -> {
			 	AdRequestDTO r = new AdRequestDTO();
				 AdvertCopy ad = advertRepository.findByRequestsRequestId(request.getRequestId())
						 .orElseThrow(NullPointerException::new);
			 	r.setAdvertId(ad.getAdvertCopyId());
			 	r.setEndDate(request.getStartReservationDate());
			 	r.setStartDate(request.getEndReservationDate());

			 	requests.add(r);
			 });
		}

		dto.setRequests(requests);

		return dto;
	}
}