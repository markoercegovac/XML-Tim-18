package com.example.advertmanagerapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="CarFuelType")
public class CarFuelType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
   // @Min(2)
    // @Max(32)
    private String fuelType;

    @Column
    private boolean isRemoved;

}
