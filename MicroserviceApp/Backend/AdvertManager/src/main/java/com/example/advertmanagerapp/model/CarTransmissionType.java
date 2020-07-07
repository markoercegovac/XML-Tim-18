package com.example.advertmanagerapp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="CarTransmissionType")
public class CarTransmissionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    //Min(2)
    //@Max(32)
    private String transmissionType;

    @Column
    private boolean isRemoved;

}