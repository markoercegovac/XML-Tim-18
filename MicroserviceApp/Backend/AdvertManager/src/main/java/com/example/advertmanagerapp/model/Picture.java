package com.example.advertmanagerapp.model;

import lombok.Data;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Data
@Entity
@Table(name="Picture")
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String picture;

    @Column
    private String path;

    @Column
    private boolean isDeleted;
}
