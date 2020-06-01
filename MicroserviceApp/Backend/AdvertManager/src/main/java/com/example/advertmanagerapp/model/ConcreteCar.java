package com.example.advertmanagerapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class ConcreteCar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long concreteCarId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carBrand_id", referencedColumnName = "id")
    private CarBrand carBrand;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carClass_id", referencedColumnName = "id")
    private CarClass carClass;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carFuelType_id", referencedColumnName = "id")
    private CarFuelType carFuelType;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carModel_id", referencedColumnName = "id")
    private CarModel carModel;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carTransmissionType_id", referencedColumnName = "id")
    private CarTransmissionType carTransmissionType;


    @OneToMany(mappedBy = "concreteCar",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<OwnersCar> ownersCar;
}
