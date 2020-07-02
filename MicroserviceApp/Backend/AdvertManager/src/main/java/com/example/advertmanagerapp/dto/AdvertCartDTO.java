package com.example.advertmanagerapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdvertCartDTO {

    private Long advertId;
    private String ownerEmail;
    private String profileImage;
    private double price;
    private Date startDate;
    private Date endDate;
}
