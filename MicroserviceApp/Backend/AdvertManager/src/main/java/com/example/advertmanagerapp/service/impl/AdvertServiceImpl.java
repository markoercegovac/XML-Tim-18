package com.example.advertmanagerapp.service.impl;

import com.example.advertmanagerapp.converter.AdvertConverter;
import com.example.advertmanagerapp.dto.AdvertDetailDTO;
import com.example.advertmanagerapp.model.Advert;
import com.example.advertmanagerapp.repository.AdvertRepository;
import com.example.advertmanagerapp.dto.AdvertDto;
import com.example.advertmanagerapp.dto.mapper.DtoEntity;
import com.example.advertmanagerapp.dto.mapper.DtoUtils;
import com.example.advertmanagerapp.model.*;


import com.example.advertmanagerapp.service.AdvertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdvertServiceImpl implements AdvertService {

    private final AdvertRepository advertRepository;
    private final DtoUtils dtoUtils;

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

    @Override
    public void createAdvert(AdvertDto advertDto) {
        Advert advert= (Advert) dtoUtils.convertToEntity(new Advert(),advertDto);
        Picture p=new Picture();
        p.setAdvert(advert);
        p.setDeleted(false);


        //dodati cenovnik i automobil vezu

        advert.getPictureSet().addAll(advert.getPictureSet());
        advertRepository.save(advert);
    }

    @Override
    public List<DtoEntity> allAdverts() {
        return advertRepository.findAll().stream().map(a->dtoUtils.convertToDto(a,new AdvertDto())).collect(Collectors.toList());
    }

}
