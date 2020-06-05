package com.example.advertmanagerapp.service;

import com.example.advertmanagerapp.dto.AdvertDetailDTO;
import org.springframework.stereotype.Service;


import com.example.advertmanagerapp.dto.AdvertDto;
import com.example.advertmanagerapp.dto.mapper.DtoEntity;

import java.util.List;
@Service
public interface AdvertService {
    AdvertDetailDTO detailAdForClient(Long advertId);
    void createAdvert(AdvertDto advertDto);
    List<DtoEntity> allAdverts();
}
