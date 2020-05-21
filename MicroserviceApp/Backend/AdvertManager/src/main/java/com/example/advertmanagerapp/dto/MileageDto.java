package com.example.advertmanagerapp.dto;

import com.example.advertmanagerapp.model.enums.TraveledUnit;
import lombok.Data;


@Data
public class MileageDto {

    private Long id;
    private Long traveledDistance;
    private TraveledUnit traveledUnit;
    private boolean isRemoved;

}
