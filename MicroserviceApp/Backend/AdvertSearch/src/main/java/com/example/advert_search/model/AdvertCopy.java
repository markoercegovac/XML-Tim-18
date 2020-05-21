package com.example.advert_search.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
public class AdvertCopy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long advertCopyId;

    @Column
    private String city;

    @Column
    private Date startOfAdvert;

    @Column
    private Date endOfAdvert;

    @Column
    private String carMark;

    @Column
    private String modelMark;

    @Column
    private String carFuelType;

    @Column
    private String carTransmissionType;

    @Column
    private String carClass;

    @Column
    private float priceFrom;

    @Column
    private float priceTo;

    @Column
    private float traveledKm;

    @Column
    private float plannedKm;

    @Column
    private boolean insurance;

    @Column
    private int numberOfSeats;

    @Column
    private String profilePicture;

    @Column
    private float mark;

    @Column
    private float price;








}
