package com.example.advertmanagerapp.service.impl;

import com.example.advertmanagerapp.dto.CarFuelTypeDto;
import com.example.advertmanagerapp.dto.mapper.DtoEntity;
import com.example.advertmanagerapp.dto.mapper.DtoUtils;
import com.example.advertmanagerapp.repository.CarFuelTypeRepository;
import com.example.advertmanagerapp.service.CarFuelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarFuelServiceImplementation implements CarFuelService {
    private final CarFuelTypeRepository carFuelTypeRepository;
    private final DtoUtils dtoUtils;

    @Override
    public List<DtoEntity> allFuels() {
        return carFuelTypeRepository.findAll().stream().map(f->dtoUtils.convertToDto(f,new CarFuelTypeDto())).collect(Collectors.toList());
    }
}
