package com.example.advertmanagerapp.dto;

import com.example.advertmanagerapp.dto.mapper.DtoEntity;
import com.example.advertmanagerapp.model.*;
import lombok.Data;


import java.util.Set;

//Nije finalan moguce da fali neko polje
@Data
public class CarDto implements DtoEntity {


    private String name;
    private Long id;
    private CarBrandDto carBrand;
    private Long carClassId;
    private Long carFuelTypeId;
    private Long carModelId;
    private Long carTransmissionTypeId;
    private Long travelDistanceConstraint;
    private boolean isInsurance;
    private int childrenSitNumber;
    private String year;
}
