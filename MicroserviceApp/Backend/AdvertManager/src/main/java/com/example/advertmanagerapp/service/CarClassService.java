package com.example.advertmanagerapp.service;

import com.example.advertmanagerapp.model.CarClass;

import java.util.List;

public interface CarClassService {

    public void deleteCarClass(Long id);
    public void saveCarClass(CarClass carClass);
    public List<CarClass> getAllCarClass();
}
