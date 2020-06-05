package com.example.advertmanagerapp.service.impl;

import com.example.advertmanagerapp.model.CarClass;
import com.example.advertmanagerapp.repository.CarClassRepository;
import com.example.advertmanagerapp.service.CarClassService;
import com.netflix.discovery.converters.Auto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CarClassServiceImpl implements CarClassService {

    @Autowired
    public CarClassRepository repository;

    @Override
    public void deleteCarClass(Long id) {
        repository.delete(repository.findById(id).get());
    }

    @Override
    public void saveCarClass(CarClass carClass) {
        repository.save(carClass);
    }

    @Override
    public List<CarClass> getAllCarClass() {
       return repository.findAll();
    }
}
