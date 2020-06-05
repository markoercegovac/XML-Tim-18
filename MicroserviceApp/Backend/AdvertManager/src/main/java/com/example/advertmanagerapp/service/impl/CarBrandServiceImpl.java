package com.example.advertmanagerapp.service.impl;


import com.example.advertmanagerapp.model.CarBrand;
import com.example.advertmanagerapp.repository.CarBrandRepository;
import com.example.advertmanagerapp.service.CarBrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CarBrandServiceImpl implements CarBrandService {

    @Autowired
    private CarBrandRepository repository;

    @Override
    public void updateCarBrand(CarBrand carBrand) {

        repository.findById(carBrand.getId()).get().setName(carBrand.getName());
    }

    @Override
    public void deleteCarBrand(Long id) {

        repository.delete(repository.findById(id).get());
    }

    @Override
    public void saveCarBrand(CarBrand carBrand) {
        repository.save(carBrand);
    }

    @Override
    public List<CarBrand> getAllCarBrand() {
        return repository.findAll();
    }
}
