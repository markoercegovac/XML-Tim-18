package com.example.advertmanagerapp.dto;


import com.example.advertmanagerapp.dto.mapper.DtoEntity;
import lombok.Data;

@Data
public class CarFuelTypeDto implements DtoEntity {

    private Long id;
    private String fuelType;
    private boolean isRemoved;
}
