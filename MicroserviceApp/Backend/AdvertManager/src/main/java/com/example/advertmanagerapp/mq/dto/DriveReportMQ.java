package com.example.advertmanagerapp.mq.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriveReportMQ {

	protected Long id;
	protected Float traveledDistance;
	protected String description;
	protected Date dateOfReport;
	protected Long carId;

}
