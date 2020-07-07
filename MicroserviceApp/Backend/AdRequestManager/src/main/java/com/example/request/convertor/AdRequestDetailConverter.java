package com.example.request.convertor;

import com.example.request.dto.AdRequestDTO;
import com.example.request.dto.AdRequestDetailedDTO;
import com.example.request.model.RequestBundle;

import java.util.HashSet;
import java.util.Set;

public abstract   class AdRequestDetailConverter {

    public static AdRequestDetailedDTO fromBundleToAdRequestDetail(RequestBundle bundle) throws NullPointerException {

        AdRequestDetailedDTO dto = new AdRequestDetailedDTO();
        dto.setPriceWithDiscount(bundle.getPriceWithDiscount());
        dto.setRequestBundleId(bundle.getRequestBundleId());
        dto.setAdvertOwnerEmail(bundle.getOwnerEmail());
        dto.setStatus(bundle.getAdvertState().toString());

        Set<AdRequestDTO> requests = new HashSet<AdRequestDTO>();
        if(bundle.getRequests().size() != 0) {
            bundle.getRequests().forEach(request -> {
                AdRequestDTO r = new AdRequestDTO();
                r.setAdvertId(request.getRequestId());
                r.setEndDate(request.getStartReservationDate());
                r.setStartDate(request.getEndReservationDate());

                requests.add(r);
            });
        }

        dto.setAdvertRequests(requests);

        return dto;
    }

}
