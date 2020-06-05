package com.example.advertmanagerapp.dto;


import com.example.advertmanagerapp.dto.mapper.DtoEntity;
import lombok.Data;

@Data
public class CarModelDto implements DtoEntity {


    private Long id;
    private String modelName;
    private boolean isRemoved;
}
