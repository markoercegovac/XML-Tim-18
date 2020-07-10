package com.example.advertmanagerapp.service.impl;

import com.example.advertmanagerapp.dto.PriceDto;
import com.example.advertmanagerapp.dto.mapper.DtoUtils;
import com.example.advertmanagerapp.model.Advert;
import com.example.advertmanagerapp.model.ClientCopy;
import com.example.advertmanagerapp.model.Price;
import com.example.advertmanagerapp.repository.ClientCopyRepository;
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
    private final ClientCopyRepository clientCopyRepository;

    private final DtoUtils dtoUtils;

    @Override
    public void savePrice(PriceDto priceDto,String ownerEmail) {
        ClientCopy clientCopy=clientCopyRepository.findByEmail(ownerEmail);
        Price price = (Price) dtoUtils.convertToEntity(new Price(),priceDto);
        price.setId(null);
        clientCopy.getPriceList().add(price);
        priceRepository.save(price);
        clientCopyRepository.save(clientCopy);

    }

    @Override
    public List<PriceDto> allPrices(String ownerEmail) {
        ClientCopy clientCopy=clientCopyRepository.findByEmail(ownerEmail);
        List<Price> prices=clientCopy.getPriceList();
        List<PriceDto>priceDtos=new ArrayList<>();
        prices.forEach(p->{priceDtos.add((PriceDto) dtoUtils.convertToDto(p,new PriceDto()));
        });
        return priceDtos;
    }
}
