package com.example.advert_search.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AdvertCopyDto {

    private Long id;
    private String city;
    private Date startOfAdvert;
    private Date endOfAdvert;
    private String carMark;
    private String modelMark;
    private String carFuelType;
    private String carTransmissionType;
    private String carClass;
    private float priceFrom;
    private float priceTo;
    private float traveledKm;
    private float plannedKm;
    private boolean insurance;
    private int numberOfSeats;
    private String picture;
    private float mark;
    private float price;

}
