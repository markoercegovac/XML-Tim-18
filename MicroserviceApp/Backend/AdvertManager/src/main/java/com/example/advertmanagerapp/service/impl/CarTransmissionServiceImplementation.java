package com.example.advertmanagerapp.service.impl;

import com.example.advertmanagerapp.dto.CarTransmissionTypeDto;
import com.example.advertmanagerapp.dto.mapper.DtoEntity;
import com.example.advertmanagerapp.dto.mapper.DtoUtils;
import com.example.advertmanagerapp.repository.CarTransmissionTypeRepository;
import com.example.advertmanagerapp.service.CarTransmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarTransmissionServiceImplementation implements CarTransmissionService {

    private final CarTransmissionTypeRepository carTransmissionTypeRepository;
    private final DtoUtils dtoUtils;

    @Override
    public List<DtoEntity> getAllTransmissionType() {
        return carTransmissionTypeRepository.findAll().stream().map(t->dtoUtils.convertToDto(t,new CarTransmissionTypeDto())).collect(Collectors.toList());
    }
}
