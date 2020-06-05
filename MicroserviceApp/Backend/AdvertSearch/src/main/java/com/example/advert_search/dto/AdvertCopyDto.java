package com.example.advert_search.dto;

import com.example.advert_search.dto.mapper.DtoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
@Data
public class AdvertCopyDto implements DtoEntity {

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

    public AdvertCopyDto(String city, Date datep1, Date datek1) {
        this.city=city;
        this.startOfAdvert=datep1;
        this.endOfAdvert=datek1;
    }
}
