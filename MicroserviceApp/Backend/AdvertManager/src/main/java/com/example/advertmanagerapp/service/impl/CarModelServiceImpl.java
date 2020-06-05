package com.example.advertmanagerapp.service.impl;

import com.example.advertmanagerapp.model.CarModel;
import com.example.advertmanagerapp.repository.CarModelRepository;
import com.example.advertmanagerapp.service.CarModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CarModelServiceImpl implements CarModelService {

    @Autowired
    public CarModelRepository repository;

    @Override
    public void deleteCarModel(Long id) {
        repository.delete(repository.findById(id).get());
    }

    @Override
    public void saveCarModel(CarModel carModel) {
        repository.save(carModel);
    }

    @Override
    public List<CarModel> getAllCarModel() {
        return repository.findAll();
    }
}
