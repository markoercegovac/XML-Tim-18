package com.example.advertmanagerapp.dto;

import com.example.advertmanagerapp.model.OwnersCar;
import lombok.Data;


import java.util.Date;

@Data
public class DriveReportDto {


    private Long id;
    private float traveledDistance;
    private String describe;
    private Date dateOfReport;
    private OwnersCar ownersCarReport;
    private Long carId;
}
