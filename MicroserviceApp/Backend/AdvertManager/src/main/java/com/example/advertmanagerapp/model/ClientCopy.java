package com.example.advertmanagerapp.model;

import lombok.Data;
import com.example.advertmanagerapp.model.enums.Role;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table
public class ClientCopy implements Serializable {

    @Id
    private String email;

    @Column(nullable = true)
    private String name;

    @Column(nullable = true)
    private String surname;

    @Column
    private String state;

    @Column
    private String city;

    @Column
    private String street;

    @Column
    private String streetNumber;

    @Column
    private String password;

    @Column
    private boolean isBanned;

    @Column
    private boolean isRemoved;

    @Column(nullable = true)
    private String companyName;

    @Column(nullable = true)
    private String companyRegistrationNumber;

    @Enumerated(EnumType.STRING)
    @Column
    private Role role;

//    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    private Set<OwnersCar> ownersCars;

    @OneToMany(mappedBy = "clientAd",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Advert> adverts;


}
