package com.example.advert_search.mq.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdSearchMQ {
	
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
	private List<AdSearchReservedDate> carReservationDate;
}