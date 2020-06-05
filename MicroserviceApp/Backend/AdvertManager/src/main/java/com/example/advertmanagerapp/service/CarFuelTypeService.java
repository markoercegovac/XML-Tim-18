package com.example.advertmanagerapp.service;

import com.example.advertmanagerapp.dto.mapper.DtoEntity;
import com.example.advertmanagerapp.model.CarFuelType;

import java.util.List;

public interface CarFuelTypeService {

    public void deleteFuelTypeService(Long id);
    public void saveFuelType(CarFuelType carFuelType);
    public List<CarFuelType> getAllCarFuelType();
    List<DtoEntity> allFuels();
}
