package com.example.advert_search.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@RequiredArgsConstructor
@Data
@Entity
@Table
public class AdvertCopy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "advert_copy_id", nullable = false)
    private Long advertCopyId;

    @Column
    private String city;

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

    @OneToMany(mappedBy = "advertCopy", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CarReservedDate> carReservedDate;


    public AdvertCopy(String sabac, List<CarReservedDate> lista1) {
        this.city=sabac;
        this.carReservedDate=lista1;
    }
}
