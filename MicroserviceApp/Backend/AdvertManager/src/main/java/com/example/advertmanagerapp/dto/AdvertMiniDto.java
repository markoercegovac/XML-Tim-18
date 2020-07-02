package com.example.advertmanagerapp.dto;

import com.example.advertmanagerapp.dto.mapper.DtoEntity;
import lombok.Data;

@Data
public class AdvertMiniDto implements DtoEntity {
    private Long advertId;
    private String profileImage;
    private float price;
    private float grade;
    private float traveledDistance;
    private String distanceUnit;
    private String carBrand;
    private String carModel;
}
