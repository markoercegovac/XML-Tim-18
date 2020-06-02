package com.example.advertmanagerapp.service.impl;

import com.example.advertmanagerapp.dto.CreateAdvertDto;
import com.example.advertmanagerapp.dto.mapper.DtoUtils;
import com.example.advertmanagerapp.model.Advert;
import com.example.advertmanagerapp.model.OwnersCar;
import com.example.advertmanagerapp.repository.AdvertRepository;
import com.example.advertmanagerapp.repository.OwnersCarRepository;
import com.example.advertmanagerapp.repository.PriceRepository;
import com.example.advertmanagerapp.service.AdvertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdvertServiceImpl implements AdvertService {

    private final AdvertRepository advertRepository;
    private final OwnersCarRepository ownersCarRepository;
    private final PriceRepository priceRepository;

    private final DtoUtils dtoUtils;

    @Override
    public void createAdvert(CreateAdvertDto createAdvertDto) {

    }
}
