package com.user.manager.dto;

import com.user.manager.mapper.DtoEntity;
import lombok.Data;

@Data
public class UserDto implements DtoEntity {
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
