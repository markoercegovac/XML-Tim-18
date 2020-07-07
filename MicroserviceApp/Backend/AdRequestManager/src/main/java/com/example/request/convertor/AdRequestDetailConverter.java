package com.example.request.convertor;

import com.example.request.dto.AdRequestDTO;
import com.example.request.dto.AdRequestDetailedDTO;
import com.example.request.model.AdvertCopy;
import com.example.request.model.RequestBundle;
import com.example.request.repository.AdvertCopyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class AdRequestDetailConverter {

    private final AdvertCopyRepository advertRepository;

    public AdRequestDetailedDTO fromBundleToAdRequestDetail(RequestBundle bundle) throws NullPointerException {

        AdRequestDetailedDTO dto = new AdRequestDetailedDTO();
        dto.setPriceWithDiscount(bundle.getPriceWithDiscount());
        dto.setRequestBundleId(bundle.getRequestBundleId());
        dto.setAdvertOwnerEmail(bundle.getOwnerEmail());
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

        dto.setAdvertRequests(requests);

        return dto;
    }

}
