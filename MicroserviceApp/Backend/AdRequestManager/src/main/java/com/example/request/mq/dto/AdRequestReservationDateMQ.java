package com.example.request.mq.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdRequestReservationDateMQ {
	
	private Long carReservedDateId;
    private Date startDate;
    private Date endDate;
}