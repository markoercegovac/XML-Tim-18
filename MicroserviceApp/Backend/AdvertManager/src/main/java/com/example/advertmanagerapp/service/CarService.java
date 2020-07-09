package com.example.advertmanagerapp.service;

import com.example.advertmanagerapp.dto.CarDto;
import com.example.advertmanagerapp.dto.mapper.DtoEntity;
import com.example.advertmanagerapp.model.ConcreteCar;

import java.util.List;

public interface CarService {
    List<DtoEntity> getCarBrands();
    List<DtoEntity> getCarModels(Long brandId);
    List<DtoEntity> getFuelTypes();
    List<DtoEntity> getCarClasses();
    List<DtoEntity> getTransmissions();
    void createCar(CarDto carDto);

    //Prilagoditi za usere
    List<DtoEntity> getAllCars();
    List<CarDto> getAllConcreteCar();
}
