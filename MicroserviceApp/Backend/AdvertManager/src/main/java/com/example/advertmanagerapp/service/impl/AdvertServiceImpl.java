package com.example.advertmanagerapp.service.impl;

import com.example.advertmanagerapp.dto.AdvertDto;
import com.example.advertmanagerapp.dto.mapper.DtoEntity;
import com.example.advertmanagerapp.dto.mapper.DtoUtils;
import com.example.advertmanagerapp.model.*;
import com.example.advertmanagerapp.repository.AdvertRepository;
import com.example.advertmanagerapp.repository.ConcreteCarRepository;
import com.example.advertmanagerapp.repository.OwnersCarRepository;
import com.example.advertmanagerapp.repository.PriceRepository;
import com.example.advertmanagerapp.service.AdvertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdvertServiceImpl implements AdvertService {

    private final AdvertRepository advertRepository;
    private final OwnersCarRepository ownersCarRepository;
    private final PriceRepository priceRepository;
    private final ConcreteCarRepository concreteCarRepository;

    private final DtoUtils dtoUtils;


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
