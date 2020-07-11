package com.example.advertmanagerapp.service;

import com.example.advertmanagerapp.dto.PriceDto;
import com.example.advertmanagerapp.model.Price;

import java.util.List;

public interface PriceService  {
    Price savePrice(PriceDto priceDto);
    List<PriceDto> allPrices();
}
