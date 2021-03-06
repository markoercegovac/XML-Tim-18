package com.example.advertmanagerapp.service;

import com.example.advertmanagerapp.dto.mapper.DtoEntity;
import com.example.advertmanagerapp.model.CarTransmissionType;

import java.util.List;


public interface CarTranssmisionTypeService {
    public void deleteCarTranssmision(Long id);
    public CarTransmissionType saveCarTranssmisionType(CarTransmissionType carTransmissionType);
    public List<CarTransmissionType> getAllCarTranssmisionType();
    List<DtoEntity> getAllTransmissionType();
}
