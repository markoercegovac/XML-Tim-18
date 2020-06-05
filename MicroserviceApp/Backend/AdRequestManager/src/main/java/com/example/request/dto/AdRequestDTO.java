package com.example.request.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdRequestDTO {

    private Long advertId;
    private Date startDate;
    private Date endDate;
}
