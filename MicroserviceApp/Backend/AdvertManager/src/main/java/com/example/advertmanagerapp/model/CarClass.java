package com.example.advertmanagerapp.model;


import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name="CarClass")
public class CarClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    //@Min(2)
    //@Max(32)
    private String className;
    @Column
    private boolean isRemoved;

}