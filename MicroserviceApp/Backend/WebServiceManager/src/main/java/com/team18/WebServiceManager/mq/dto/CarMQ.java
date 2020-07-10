package com.team18.WebServiceManager.mq.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;

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
	protected boolean insurance;
	protected int childrenSitNumber;
	protected boolean deleted;
}
