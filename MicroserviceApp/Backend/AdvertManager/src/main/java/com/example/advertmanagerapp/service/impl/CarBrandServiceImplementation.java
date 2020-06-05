package com.example.advertmanagerapp.service.impl;

import com.example.advertmanagerapp.dto.CarBrandDto;
import com.example.advertmanagerapp.dto.mapper.DtoEntity;
import com.example.advertmanagerapp.dto.mapper.DtoUtils;
import com.example.advertmanagerapp.model.CarBrand;
import com.example.advertmanagerapp.repository.CarBrandRepository;
import com.example.advertmanagerapp.service.CarBrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarBrandServiceImplementation implements CarBrandService {

    private final CarBrandRepository carBrandRepository;

    private final DtoUtils dtoUtils;

    @Override
    public List<DtoEntity> getAllBrands() {
        return carBrandRepository.findAll().stream().map(b->dtoUtils.convertToDto(b,new CarBrandDto())).collect(Collectors.toList());
    }
}
