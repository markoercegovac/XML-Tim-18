package com.example.request.service;

import com.example.request.dto.AdRequestDetailedDTO;
import com.example.request.model.RequestBundle;
import com.example.request.repository.RequestBundleRepository;
import com.example.request.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

    private final RequestBundleRepository requestBundleRepo;

    //JUST TO TEST DA CONNECTION
    public AdRequestDetailedDTO getSpecificBundleWithoutRequests(Long requestId) {
        RequestBundle fined = requestBundleRepo.findById(requestId).orElse(null);
        AdRequestDetailedDTO ret = new AdRequestDetailedDTO();

        if(fined != null) {
            ret.setAdvertOwnerEmail(fined.getOwnerEmail());
            ret.setPriceWithDiscount(fined.getPriceWithDiscount());
        }

        return ret;
    }

}
