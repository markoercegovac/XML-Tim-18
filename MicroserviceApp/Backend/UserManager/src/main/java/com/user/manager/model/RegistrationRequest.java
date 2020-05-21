package com.user.manager.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class RegistrationRequest {

    @Id
    private String email;

    @Column(nullable = true)
    private String name;

    @Column(nullable = true)
    private String surname;

    @Column(nullable = true)
    private String state;

    @Column(nullable = true)
    private String city;

    @Column(nullable = true)
    private String street;

    @Column(nullable = true)
    private String streetNumber;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private String companyName;

    @Column(nullable = true)
    private String companyRegistrationNumber;


}
