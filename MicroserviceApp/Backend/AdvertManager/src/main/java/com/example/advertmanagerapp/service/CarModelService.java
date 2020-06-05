package com.example.advertmanagerapp.service;


import com.example.advertmanagerapp.model.CarModel;

import java.util.List;

public interface CarModelService {

    public void deleteCarModel(Long id);
    public void saveCarModel(CarModel carModel);
    public List<CarModel> getAllCarModel();
}
