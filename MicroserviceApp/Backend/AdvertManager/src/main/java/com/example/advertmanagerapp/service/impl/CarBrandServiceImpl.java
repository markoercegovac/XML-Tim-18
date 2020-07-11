package com.example.advertmanagerapp.service.impl;


import com.example.advertmanagerapp.dto.CarBrandDto;
import com.example.advertmanagerapp.dto.mapper.DtoEntity;
import com.example.advertmanagerapp.dto.mapper.DtoUtils;
import com.example.advertmanagerapp.model.CarBrand;
import com.example.advertmanagerapp.repository.CarBrandRepository;
import com.example.advertmanagerapp.service.CarBrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CarBrandServiceImpl implements CarBrandService {


    private final CarBrandRepository repository;
    private final DtoUtils dtoUtils;

    @Override
    public List<DtoEntity> getAllBrands() {
        return repository.findAll().stream().map(b->dtoUtils.convertToDto(b,new CarBrandDto())).collect(Collectors.toList());
    }
    @Override
    public void updateCarBrand(CarBrand carBrand) {

        repository.findById(carBrand.getId()).get().setName(carBrand.getName());
    }

    @Override
    public void deleteCarBrand(Long id) {

        repository.delete(repository.findById(id).get());
    }

    @Override
    public CarBrand saveCarBrand(CarBrand carBrand) {
        return repository.save(carBrand);
    }

    @Override
    public List<CarBrand> getAllCarBrand() {
        return repository.findAll();
    }
}
