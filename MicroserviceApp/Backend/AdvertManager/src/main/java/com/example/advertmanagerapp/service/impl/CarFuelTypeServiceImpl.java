package com.example.advertmanagerapp.service.impl;


import com.example.advertmanagerapp.dto.CarFuelTypeDto;
import com.example.advertmanagerapp.dto.mapper.DtoEntity;
import com.example.advertmanagerapp.dto.mapper.DtoUtils;
import com.example.advertmanagerapp.model.CarFuelType;
import com.example.advertmanagerapp.repository.CarFuelTypeRepository;
import com.example.advertmanagerapp.service.CarFuelTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CarFuelTypeServiceImpl implements CarFuelTypeService {
    private final CarFuelTypeRepository repository;
    private final CarFuelTypeRepository carFuelTypeRepository;
    private final DtoUtils dtoUtils;

    @Override
    public List<DtoEntity> allFuels() {
        return carFuelTypeRepository.findAll().stream().map(f->dtoUtils.convertToDto(f,new CarFuelTypeDto())).collect(Collectors.toList());
    }

    @Override
    public void deleteFuelTypeService(Long id) {
        repository.delete(repository.findById(id).get());
    }

    @Override
    public CarFuelType saveFuelType(CarFuelType carFuelType) {
        return repository.save(carFuelType);
    }

    @Override
    public List<CarFuelType> getAllCarFuelType() {
        return repository.findAll();
    }
}
