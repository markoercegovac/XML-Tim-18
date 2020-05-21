package com.example.advertmanagerapp.model;


import lombok.Data;
import com.example.advertmanagerapp.model.enums.TraveledUnit;

import javax.persistence.*;

@Data
@Entity
@Table(name="Mileage")
public class Mileage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Long traveledDistance;

    @Enumerated(EnumType.STRING)
    @Column
    private TraveledUnit traveledUnit;

    @Column
    private boolean isRemoved;
}