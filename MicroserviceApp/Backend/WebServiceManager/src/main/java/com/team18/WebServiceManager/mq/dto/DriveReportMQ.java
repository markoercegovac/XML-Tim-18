package com.team18.WebServiceManager.mq.dto;

import java.util.Date;

public class DriveReportMQ {

	protected Long id;
	protected Float traveledDistance;
	protected String description;
	protected Date dateOfReport;
	protected Long carId;

	public DriveReportMQ() {
	}

	public DriveReportMQ(Long id, Float traveledDistance, String description, Date dateOfReport, Long carId) {
		this.id = id;
		this.traveledDistance = traveledDistance;
		this.description = description;
		this.dateOfReport = dateOfReport;
		this.carId = carId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getTraveledDistance() {
		return traveledDistance;
	}

	public void setTraveledDistance(Float traveledDistance) {
		this.traveledDistance = traveledDistance;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateOfReport() {
		return dateOfReport;
	}

	public void setDateOfReport(Date dateOfReport) {
		this.dateOfReport = dateOfReport;
	}

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}
}
