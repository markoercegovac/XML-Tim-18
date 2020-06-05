package com.example.advertmanagerapp.service.impl;

import com.example.advertmanagerapp.model.CarTransmissionType;
import com.example.advertmanagerapp.repository.CarTranssmisionTypeRepository;
import com.example.advertmanagerapp.service.CarTranssmisionTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CarTranssmisionTypeServiceImpl implements CarTranssmisionTypeService {

    @Autowired
    public CarTranssmisionTypeRepository repository;

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
