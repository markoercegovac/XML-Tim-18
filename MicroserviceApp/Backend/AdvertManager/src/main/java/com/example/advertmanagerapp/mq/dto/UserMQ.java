package com.example.advertmanagerapp.mq.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMQ {

    private String email;
    private String name;
    private String surname;
    private String companyName;
    private boolean isForbiddenAdvert;
    private boolean isCreationEnabled;
}
