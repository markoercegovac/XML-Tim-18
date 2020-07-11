package com.example.advertmanagerapp.service.impl;

import com.example.advertmanagerapp.dto.PriceDto;
import com.example.advertmanagerapp.dto.mapper.DtoUtils;
import com.example.advertmanagerapp.model.Advert;
import com.example.advertmanagerapp.model.Price;
import com.example.advertmanagerapp.repository.PriceRepository;
import com.example.advertmanagerapp.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PriceServiceImplementation implements PriceService {

    private final PriceRepository priceRepository;

    private final DtoUtils dtoUtils;

    @Override
    public Price savePrice(PriceDto priceDto) {
        Price price = (Price) dtoUtils.convertToEntity(new Price(),priceDto);
        return priceRepository.save(price);
    }

    @Override
    public List<PriceDto> allPrices() {
        List<Price> prices=priceRepository.findAll();
        List<PriceDto>priceDtos=new ArrayList<>();
        prices.forEach(p->{priceDtos.add((PriceDto) dtoUtils.convertToDto(p,new PriceDto()));
        });
        return priceDtos;
    }
}
