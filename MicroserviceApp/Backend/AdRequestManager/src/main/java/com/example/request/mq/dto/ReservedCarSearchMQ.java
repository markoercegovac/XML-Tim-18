package com.example.request.mq.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservedCarSearchMQ {

	private Date start;
	private Date end;
	private Long AdId;

}
