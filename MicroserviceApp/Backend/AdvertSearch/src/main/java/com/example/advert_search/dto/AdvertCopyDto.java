package com.example.advert_search.dto;

import com.example.advert_search.dto.mapperGenericki.DtoEntity;
import com.example.advert_search.model.CarReservedDate;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
public class AdvertCopyDto implements DtoEntity {

    private Long advertCopyId;
    private String city;
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
    private String profilePicture;
    private float mark;
    private float price;
    private List<CarReservedDate> carReservedDate;

    public AdvertCopyDto(String city, List<CarReservedDate> listaZauzeca) {
        this.city=city;
        this.carReservedDate= listaZauzeca;

    }
}
