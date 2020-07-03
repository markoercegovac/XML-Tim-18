package com.example.advertmanagerapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdvertDetailDTO {

    /**
     * Data types are Obj becouse they can be null, accept pricePerDay
     * */
    private Long advertId;
    private List<String> gallery;
    private String description;
    private float pricePerDay;
    private float mileage;
    private String mileageUnit;
    private Float insurancePrice;
    private Float distanceOverflowPrice;
    private Float discount;
    private String carBrand;
    private String carClass;
    private String carFuelType;
    private String carModel;
    private String carTransmissionType;
    private int carChildSeatNumber;
    private Long carAvailableDistanceWithoutOverflowPrice;
}
