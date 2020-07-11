package com.team18.WebServiceManager.mq.dto;

import javax.xml.bind.annotation.XmlElement;


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

	public CarMQ() {
	}

	public CarMQ(Long id, Long carBrandId, Long carModelId, Long carClassId, Long carFuelTypeId, Long carTransmissionId, Long traveledDistance, Long traveledDistanceConstraint, boolean insurance, int childrenSitNumber, boolean deleted) {
		this.id = id;
		this.carBrandId = carBrandId;
		this.carModelId = carModelId;
		this.carClassId = carClassId;
		this.carFuelTypeId = carFuelTypeId;
		this.carTransmissionId = carTransmissionId;
		this.traveledDistance = traveledDistance;
		this.traveledDistanceConstraint = traveledDistanceConstraint;
		this.insurance = insurance;
		this.childrenSitNumber = childrenSitNumber;
		this.deleted = deleted;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCarBrandId(Long carBrandId) {
		this.carBrandId = carBrandId;
	}

	public void setCarModelId(Long carModelId) {
		this.carModelId = carModelId;
	}

	public void setCarClassId(Long carClassId) {
		this.carClassId = carClassId;
	}

	public void setCarFuelTypeId(Long carFuelTypeId) {
		this.carFuelTypeId = carFuelTypeId;
	}

	public void setCarTransmissionId(Long carTransmissionId) {
		this.carTransmissionId = carTransmissionId;
	}

	public void setTraveledDistance(Long traveledDistance) {
		this.traveledDistance = traveledDistance;
	}

	public void setTraveledDistanceConstraint(Long traveledDistanceConstraint) {
		this.traveledDistanceConstraint = traveledDistanceConstraint;
	}

	public void setInsurance(boolean insurance) {
		this.insurance = insurance;
	}

	public void setChildrenSitNumber(int childrenSitNumber) {
		this.childrenSitNumber = childrenSitNumber;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Long getId() {
		return id;
	}

	public Long getCarBrandId() {
		return carBrandId;
	}

	public Long getCarModelId() {
		return carModelId;
	}

	public Long getCarClassId() {
		return carClassId;
	}

	public Long getCarFuelTypeId() {
		return carFuelTypeId;
	}

	public Long getCarTransmissionId() {
		return carTransmissionId;
	}

	public Long getTraveledDistance() {
		return traveledDistance;
	}

	public Long getTraveledDistanceConstraint() {
		return traveledDistanceConstraint;
	}

	public boolean isInsurance() {
		return insurance;
	}

	public int getChildrenSitNumber() {
		return childrenSitNumber;
	}

	public boolean isDeleted() {
		return deleted;
	}
}
