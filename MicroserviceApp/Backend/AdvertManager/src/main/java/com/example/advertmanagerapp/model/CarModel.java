package com.example.advertmanagerapp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="CarModel")
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    //@Min(2)
    //@Max(32)
    private String modelName;

    @Column
    private boolean isRemoved;

}