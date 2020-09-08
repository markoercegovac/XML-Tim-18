package com.team18.WebServiceManager.ws.endpoint.dto;

import com.team18.WebServiceManager.ws.WsNameSpace;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(namespace = WsNameSpace.namespace)
@XmlType(name = "carRequest", propOrder = {
		"id",
		"token",
		"carBrandId",
		"carModelId",
		"carClassId",
		"carFuelTypeId",
		"carTransmissionId",
		"traveledDistance",
		"traveledDistanceConstraint",
		"insurance",
		"childrenSitNumber",
		"deleted"
}, namespace = WsNameSpace.namespace)
public class CarRequest {

	@XmlElement(required = true)
	protected Long id;

	@XmlElement(required = true)
	protected String token;

	@XmlElement(required = true)
	protected Long carBrandId;

	@XmlElement(required = true)
	protected Long carModelId;

	@XmlElement(required = true)
	protected Long carClassId;

	@XmlElement(required = true)
	protected Long carFuelTypeId;

	@XmlElement(required = true)
	protected Long carTransmissionId;

	@XmlElement(required = true)
	protected Long traveledDistance;

	@XmlElement(required = true)
	protected Long traveledDistanceConstraint;

	@XmlElement(required = true)
	protected boolean insurance;

	@XmlElement(required = true)
	protected int childrenSitNumber;

	@XmlElement(required = true)
	protected boolean deleted;

	public void setId(Long id) {
		this.id = id;
	}

	public void setToken(String token) {
		this.token = token;
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

	public String getToken() {
		return token;
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
