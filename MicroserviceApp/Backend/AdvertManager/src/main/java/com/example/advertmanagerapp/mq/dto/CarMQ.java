package com.example.advertmanagerapp.mq.dto;

import lombok.Data;

@Data
public class CarMQ {

	protected Long id;
	protected Long carBrandId;
	protected Long carModelId;
	protected Long carClassId;
	protected Long carFuelTypeId;
	protected Long carTransmissionId;
	protected Long traveledDistance;
	protected Long traveledDistanceConstraint;
	protected String owner;
	protected boolean insurance;
	protected int childrenSitNumber;
	protected boolean deleted;
}
