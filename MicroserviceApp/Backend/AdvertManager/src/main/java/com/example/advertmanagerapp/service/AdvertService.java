package com.example.advertmanagerapp.service;

import com.example.advertmanagerapp.dto.AdvertDto;
import com.example.advertmanagerapp.dto.mapper.DtoEntity;

import java.util.List;

public interface AdvertService {

    void createAdvert(AdvertDto advertDto);
    List<DtoEntity> allAdverts();
}
