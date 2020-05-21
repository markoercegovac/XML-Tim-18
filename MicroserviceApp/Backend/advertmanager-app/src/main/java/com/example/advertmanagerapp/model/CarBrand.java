package com.example.advertmanagerapp.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name="CarBrand")
public class CarBrand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    //@Min(2)
    //@Max(32)
    private String name;

    @Column
    private boolean isRemoved;

}