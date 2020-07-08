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
    private String insurance;
    private int numberOfSeats;
    private String profilePicture;
    private float mark;
    private float price;
    private List<CarReservedDate> carReservedDate;

    public AdvertCopyDto(String city, String carMark, String modelMark, String carFuelType, String carTransmissionType, String carClass, float priceFrom, float priceTo, float traveledKm, float plannedKm, String insurance, int numberOfSeats, float mark, List<CarReservedDate> listaZauzeca) {
        this.city=city;
        this.carMark=carMark;
        this.modelMark=modelMark;
        this.carFuelType=carFuelType;
        this.carTransmissionType=carTransmissionType;
        this.carClass=carClass;
        this.priceFrom=priceFrom;
        this.priceTo=priceTo;
        this.traveledKm=traveledKm;
        this.plannedKm=plannedKm;
        this.insurance=insurance;
        this.numberOfSeats=numberOfSeats;
        this.mark=mark;
        this.carReservedDate= listaZauzeca;

    }
}
