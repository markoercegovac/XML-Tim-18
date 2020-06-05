package com.example.advertmanagerapp.dto;


import com.example.advertmanagerapp.dto.mapper.DtoEntity;
import lombok.Data;

@Data
public class CarClassDto implements DtoEntity {


    private Long id;
    private String className;
    private boolean isRemoved;

}
