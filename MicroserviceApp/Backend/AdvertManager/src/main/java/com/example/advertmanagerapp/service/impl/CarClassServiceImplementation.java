package com.example.advertmanagerapp.service.impl;

import com.example.advertmanagerapp.dto.CarClassDto;
import com.example.advertmanagerapp.dto.mapper.DtoEntity;
import com.example.advertmanagerapp.dto.mapper.DtoUtils;
import com.example.advertmanagerapp.repository.CarClassRepository;
import com.example.advertmanagerapp.service.CarClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarClassServiceImplementation implements CarClassService {

    private final DtoUtils dtoUtils;
    private final CarClassRepository carClassRepository;

    @Override
    public List<DtoEntity> getAllCarClasses() {
        return carClassRepository.findAll().stream().map(carClass -> dtoUtils.convertToDto(carClass,new CarClassDto())).collect(Collectors.toList());
    }
}
