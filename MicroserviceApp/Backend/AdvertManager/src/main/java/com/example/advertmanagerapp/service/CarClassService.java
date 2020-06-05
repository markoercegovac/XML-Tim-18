package com.example.advertmanagerapp.service;

import com.example.advertmanagerapp.model.CarClass;
import com.example.advertmanagerapp.dto.mapper.DtoEntity;

import java.util.List;

public interface CarClassService {
    List<DtoEntity> getAllCarClasses();

    public void deleteCarClass(Long id);
    public void saveCarClass(CarClass carClass);
    public List<CarClass> getAllCarClass();
}
