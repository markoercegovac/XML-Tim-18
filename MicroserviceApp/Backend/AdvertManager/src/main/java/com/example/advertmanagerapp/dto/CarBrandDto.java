package com.example.advertmanagerapp.dto;


import com.example.advertmanagerapp.dto.mapper.DtoEntity;
import lombok.Data;

@Data
public class CarBrandDto implements DtoEntity {
    private Long id;
    private String name;
    private boolean isRemoved;

}
