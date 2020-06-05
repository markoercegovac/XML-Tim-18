package com.example.advertmanagerapp.dto;


import com.example.advertmanagerapp.dto.mapper.DtoEntity;
import lombok.Data;

@Data
public class CarTransmissionTypeDto implements DtoEntity {


    private Long id;
    private String transmissionType;
    private boolean isRemoved;
}
