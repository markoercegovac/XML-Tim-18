package com.example.advertmanagerapp.service.impl;

import com.example.advertmanagerapp.dto.PriceDto;
import com.example.advertmanagerapp.dto.mapper.DtoUtils;
import com.example.advertmanagerapp.model.Price;
import com.example.advertmanagerapp.repository.PriceRepository;
import com.example.advertmanagerapp.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceServiceImplementation implements PriceService {

    private final PriceRepository priceRepository;

    private final DtoUtils dtoUtils;

    @Override
    public void savePrice(PriceDto priceDto) {
        Price price = (Price) dtoUtils.convertToEntity(new Price(),priceDto);
        priceRepository.save(price);

    }
}
