package com.example.advertmanagerapp.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="CarTransmissionType")
public class CarTransmissionType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    //Min(2)
    //@Max(32)
    private String transmissionType;

    @Column
    private boolean isRemoved;

}