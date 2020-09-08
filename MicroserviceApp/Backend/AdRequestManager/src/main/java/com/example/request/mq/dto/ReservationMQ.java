package com.example.request.mq.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationMQ {

	protected Long id;
	protected Long advertId;
	protected String status;
	protected String userEmail;
	protected Date start;
	protected Date end;
	private String ownerEmail;

}
