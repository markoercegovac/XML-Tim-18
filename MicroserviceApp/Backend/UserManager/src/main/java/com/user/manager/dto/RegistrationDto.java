package com.user.manager.dto;

import lombok.Data;

@Data
public class RegistrationDto {
    private String email;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String companyName;
    private String companyRegistrationNumber;
    private String state;
    private String street;
    private String streetNumber;
}
