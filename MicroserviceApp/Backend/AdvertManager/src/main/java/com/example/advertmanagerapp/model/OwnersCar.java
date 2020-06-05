package com.example.advertmanagerapp.model;

import com.example.advertmanagerapp.model.enums.TraveledUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class OwnersCar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = true)
    private Long travelDistanceConstraint;

    @Column(nullable = false)
    private float mileage; //koliko je presao

    @Column(nullable = false)
    private TraveledUnit traveledUnit;

    @Column(nullable = false)
    private boolean isInsurance;

    @Column(nullable = false)
    private int childrenSitNumber;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private ConcreteCar concreteCar;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private ClientCopy client;

//    @OneToMany(mappedBy = "ownersCar",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    private Set<Advert> adverts;

    @OneToMany(mappedBy = "ownersCarReport",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<DriveReport> reports;

}
