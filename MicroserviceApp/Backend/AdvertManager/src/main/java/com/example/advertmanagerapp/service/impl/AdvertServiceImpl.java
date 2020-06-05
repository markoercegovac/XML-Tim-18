package com.example.advertmanagerapp.service.impl;

import com.example.advertmanagerapp.converter.AdvertConverter;
import com.example.advertmanagerapp.dto.AdvertDetailDTO;
import com.example.advertmanagerapp.model.Advert;
import com.example.advertmanagerapp.repository.AdvertRepository;
import com.example.advertmanagerapp.service.AdvertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdvertServiceImpl implements AdvertService {

    private final AdvertRepository advertRepository;

    public AdvertDetailDTO detailAdForClient(Long advertId) {

        try {
            Advert foundAd = advertRepository.findByIdAndIsActiveTrue(advertId).orElse(null);
            if (foundAd != null) {
                return AdvertConverter.fromAdvertToAdvertDetail(foundAd);
            } else {
                return null;
            }
        } catch (NullPointerException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
