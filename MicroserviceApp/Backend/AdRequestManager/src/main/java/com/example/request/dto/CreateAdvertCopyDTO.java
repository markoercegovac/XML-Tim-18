package com.example.request.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CreateAdvertCopyDTO {

    private Long AdvertId;
    private Date advertEndDate;
    private String ownerEmail;
    private List<DatePareDTO> reservedDateList;
}
