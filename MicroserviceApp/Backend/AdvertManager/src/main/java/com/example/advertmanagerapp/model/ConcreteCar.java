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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carBrand_id", referencedColumnName = "id")
    private CarBrand carBrand;


    @OneToOne
    @JoinColumn(name = "carClass_id", referencedColumnName = "id")
    private CarClass carClass;


    @OneToOne
    @JoinColumn(name = "carFuelType_id", referencedColumnName = "id")
    private CarFuelType carFuelType;


    @OneToOne
    @JoinColumn(name = "carModel_id", referencedColumnName = "id")
    private CarModel carModel;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carTransmissionType_id", referencedColumnName = "id")
    private CarTransmissionType carTransmissionType;

    @Column
    private String nameOfCar;

    @Column
    private String year;

    @Column
    private int travelDistanceConstraint;

    @Column
    private int childrenSitNumber;




//    @OneToMany(mappedBy = "concreteCar",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    private Set<OwnersCar> ownersCar;
}
