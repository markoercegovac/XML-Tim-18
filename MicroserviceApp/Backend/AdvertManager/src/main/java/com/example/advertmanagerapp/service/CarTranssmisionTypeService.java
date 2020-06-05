package com.example.advertmanagerapp.service;

import com.example.advertmanagerapp.model.CarTransmissionType;

import java.util.List;


public interface CarTranssmisionTypeService {

    public void deleteCarTranssmision(Long id);
    public void saveCarTranssmisionType(CarTransmissionType carTransmissionType);
    public List<CarTransmissionType> getAllCarTranssmisionType();
}
