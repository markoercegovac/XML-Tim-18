package com.example.advertmanagerapp.service.impl;


import com.example.advertmanagerapp.model.CarFuelType;
import com.example.advertmanagerapp.repository.CarFuelTypeRepository;
import com.example.advertmanagerapp.service.CarFuelTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CarFuelTypeServiceImpl implements CarFuelTypeService {

    @Autowired
    public CarFuelTypeRepository repository;

    @Override
    public void deleteFuelTypeService(Long id) {
        repository.delete(repository.findById(id).get());
    }

    @Override
    public void saveFuelType(CarFuelType carFuelType) {
        repository.save(carFuelType);
    }

    @Override
    public List<CarFuelType> getAllCarFuelType() {
        return repository.findAll();
    }
}
