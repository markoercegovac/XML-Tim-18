package com.example.advertmanagerapp.service;

import com.example.advertmanagerapp.dto.mapper.DtoEntity;
import com.example.advertmanagerapp.model.CarModel;
import java.util.List;

public interface CarModelService  {
    List<DtoEntity> getModelForBrand(Long idBrand);
    public void deleteCarModel(Long id);
    public CarModel saveCarModel(CarModel carModel);
    public List<CarModel> getAllCarModel();
}
