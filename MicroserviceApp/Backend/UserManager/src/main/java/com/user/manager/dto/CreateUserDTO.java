package com.user.manager.dto;

import lombok.Data;

@Data
public class CreateUserDTO {

    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;
    private String state;
    private String city;
    private String street;
    private String streetNumber;
}
