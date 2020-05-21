package com.example.advertmanagerapp.dto;

import com.example.advertmanagerapp.model.Advert;
import com.example.advertmanagerapp.model.OwnersCar;
import com.example.advertmanagerapp.model.enums.Role;
import lombok.Data;


import java.util.Set;
@Data
public class ClientCopyDto {


    private String email;
    private String name;
    private String surname;
    private String state;
    private String city;
    private String street;
    private String streetNumber;
    private String password;
    private boolean isBanned;
    private boolean isRemoved;
    private String companyName;
    private String companyRegistrationNumber;
    private Role role;
    private Set<OwnersCar> ownersCars;
    private Set<Advert> adverts;

}
