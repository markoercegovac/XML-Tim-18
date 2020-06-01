package com.example.advertmanagerapp.service;

import com.example.advertmanagerapp.converter.AdvertConverter;
import com.example.advertmanagerapp.dto.AdvertDetailDTO;
import com.example.advertmanagerapp.model.Advert;
import com.example.advertmanagerapp.repository.AdvertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdvertService {

    private final AdvertRepository advertRepository;

    public AdvertDetailDTO detailAdForClient(Long advertId) {

        Advert foundAd = advertRepository.findByIdAndIsActiveTrue(advertId).orElse(null);
        if(foundAd != null) {
            try {
                return AdvertConverter.fromAdvertToAdvertDetail(foundAd);
            } catch(NullPointerException e) {
                return null;
            }
        }

        return null;
    }
}
