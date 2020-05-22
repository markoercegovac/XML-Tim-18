package com.example.request.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AdRequestDTO {

    private Long advertId;
    private Date startDate;
    private Date endDate;
}
