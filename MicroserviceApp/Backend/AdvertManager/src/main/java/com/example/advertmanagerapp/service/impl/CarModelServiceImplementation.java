package com.example.advertmanagerapp.service.impl;

import com.example.advertmanagerapp.dto.CarModelDto;
import com.example.advertmanagerapp.dto.mapper.DtoEntity;
import com.example.advertmanagerapp.dto.mapper.DtoUtils;
import com.example.advertmanagerapp.model.CarBrand;
import com.example.advertmanagerapp.repository.CarBrandRepository;
import com.example.advertmanagerapp.service.CarModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarModelServiceImplementation implements CarModelService {

    private final CarBrandRepository carBrandRepository;
    private final DtoUtils dtoUtils;
    @Override
    public List<DtoEntity> getModelForBrand(Long idBrand) {
        CarBrand carBrand = carBrandRepository.findById(idBrand).get();
        return carBrand.getCarModelSet().stream().map(m->dtoUtils.convertToDto(m,new CarModelDto())).collect(Collectors.toList());
    }
}
