package com.example.advertmanagerapp.model;

import com.example.advertmanagerapp.model.enums.TraveledUnit;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table
public class OwnersCar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Long travelDistanceConstraint;

    @Column
    private TraveledUnit traveledUnit;

    @Column
    private boolean isInsurance;

    @Column
    private int childrenSitNumber;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private ConcreteCar concreteCar;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private ClientCopy client;

    @OneToMany(mappedBy = "ownersCar",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Advert> adverts;

    @OneToMany(mappedBy = "ownersCarReport",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<DriveReport> reports;

}
