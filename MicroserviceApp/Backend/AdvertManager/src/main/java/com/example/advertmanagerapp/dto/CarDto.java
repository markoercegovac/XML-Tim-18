package com.example.advertmanagerapp.dto;

import com.example.advertmanagerapp.model.*;
import lombok.Data;


import java.util.Set;

@Data
public class CarDto {


    private Long id;
    private CarBrand carBrand;
    private CarClass carClass;
    private CarFuelType carFuelType;
    private CarModel carModel;
    private CarTransmissionType carTransmissionType;
    private Mileage mileage;
    private Long travelDistanceConstraint;
    private boolean isInsurance;
    private int childrenSitNumber;
    private ClientCopy client ;
    private Set<Advert> adverts;
    private Set<DriveReport> reports;
}
