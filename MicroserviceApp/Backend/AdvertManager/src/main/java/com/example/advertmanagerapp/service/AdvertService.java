package com.example.advertmanagerapp.service;

import com.example.advertmanagerapp.dto.AdvertCartDTO;
import com.example.advertmanagerapp.dto.AdvertDetailDTO;
import com.example.advertmanagerapp.dto.AdvertMiniDto;
import org.springframework.stereotype.Service;


import com.example.advertmanagerapp.dto.AdvertDto;
import com.example.advertmanagerapp.dto.mapper.DtoEntity;

import java.io.IOException;
import java.util.List;
@Service
public interface AdvertService {
    AdvertDetailDTO detailAdForClient(Long advertId);
    void createAdvert(AdvertDto advertDto) throws IOException;
    List<DtoEntity> allAdverts();
    List<AdvertMiniDto> allAdvertsHome() throws IOException;
    AdvertCartDTO detailAdForCart(Long adId);
}
