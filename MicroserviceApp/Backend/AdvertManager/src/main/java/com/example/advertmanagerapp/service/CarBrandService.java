package com.example.advertmanagerapp.service;

import com.example.advertmanagerapp.dto.mapper.DtoEntity;
import com.example.advertmanagerapp.model.CarBrand;

import java.util.List;

public interface CarBrandService {

    public void updateCarBrand(CarBrand carBrand);
    public void deleteCarBrand(Long id);
    public CarBrand saveCarBrand(CarBrand carBrand);
    public List<CarBrand> getAllCarBrand();
    List<DtoEntity> getAllBrands();
}
