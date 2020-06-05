package com.example.advertmanagerapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


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

    @OneToMany
    private List<CarModel> carModelSet;

}