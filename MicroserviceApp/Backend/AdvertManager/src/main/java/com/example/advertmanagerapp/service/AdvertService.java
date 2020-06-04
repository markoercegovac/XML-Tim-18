package com.example.advertmanagerapp.service;

import com.example.advertmanagerapp.dto.AdvertDetailDTO;
import org.springframework.stereotype.Service;

@Service
public interface AdvertService {

    AdvertDetailDTO detailAdForClient(Long advertId);

}
