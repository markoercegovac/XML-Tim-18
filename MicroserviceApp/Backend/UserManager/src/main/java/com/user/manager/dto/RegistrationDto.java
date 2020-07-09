package com.user.manager.dto;

import lombok.Data;

@Data
public class RegistrationDto {
    private String email;
    private String username;
    private String name;
    private String surname;
    private String companyName;
    private String companyRegistrationNumber;
    private String state;
    private String city;
    private String street;
    private String streetNumber;
    private String url;
    private String role;//USER, FIRM, AGENT
}
