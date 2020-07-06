package com.example.advertmanagerapp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="CarClass")
public class CarClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    //@Min(2)
    //@Max(32)
    private String className;
    @Column
    private boolean isRemoved;

}