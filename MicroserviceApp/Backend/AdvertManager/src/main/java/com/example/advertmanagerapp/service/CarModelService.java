package com.example.advertmanagerapp.service;

import com.example.advertmanagerapp.dto.mapper.DtoEntity;

import java.util.List;

public interface CarModelService  {
    List<DtoEntity> getModelForBrand(Long idBrand);
}
