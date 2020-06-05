package com.example.advertmanagerapp.service.impl;

import com.example.advertmanagerapp.dto.CarTransmissionTypeDto;
import com.example.advertmanagerapp.dto.mapper.DtoEntity;
import com.example.advertmanagerapp.dto.mapper.DtoUtils;
import com.example.advertmanagerapp.model.CarTransmissionType;
import com.example.advertmanagerapp.repository.CarTransmissionTypeRepository;
import com.example.advertmanagerapp.repository.CarTranssmisionTypeRepository;
import com.example.advertmanagerapp.service.CarTranssmisionTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CarTranssmisionTypeServiceImpl implements CarTranssmisionTypeService {

    private final CarTranssmisionTypeRepository repository;
    private final CarTransmissionTypeRepository carTransmissionTypeRepository;
    private final DtoUtils dtoUtils;

    @Override
    public List<DtoEntity> getAllTransmissionType() {
        return carTransmissionTypeRepository.findAll().stream().map(t->dtoUtils.convertToDto(t,new CarTransmissionTypeDto())).collect(Collectors.toList());
    }
    @Override
    public void deleteCarTranssmision(Long id) {
        repository.delete(repository.findById(id).get());
    }

    @Override
    public void saveCarTranssmisionType(CarTransmissionType carTransmissionType) {

        repository.save(carTransmissionType);
    }

    @Override
    public List<CarTransmissionType> getAllCarTranssmisionType() {
        return repository.findAll();
    }
}
