package com.example.request.mq.dto;

import java.util.Date;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdRequestMQ {
	
	private Long advertCopyId;
    private Date advertEndDate;
    private String ownerEmail;
    private Set<AdRequestReservationDateMQ> carReservedDate;
}