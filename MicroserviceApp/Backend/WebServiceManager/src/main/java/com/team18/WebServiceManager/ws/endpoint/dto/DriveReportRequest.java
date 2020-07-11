package com.team18.WebServiceManager.ws.endpoint.dto;

import com.team18.WebServiceManager.ws.WsNameSpace;
import javax.xml.bind.annotation.*;
import java.util.Date;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(namespace = WsNameSpace.namespace)
@XmlType(name = "driveReportRequest", propOrder = {
		"id",
		"token",
		"traveledDistance",
		"description",
		"dateOfReport",
		"carId"
}, namespace = WsNameSpace.namespace)
public class DriveReportRequest {

	@XmlElement(required = true)
	protected Long id;

	@XmlElement(required = true)
	protected String token;

	@XmlElement(required = true)
	protected Float traveledDistance;

	@XmlElement(required = true)
	protected String description;

	@XmlElement(required = true)
	@XmlSchemaType(name = "dateTime")
	protected Date dateOfReport;

	@XmlElement(required = true)
	protected Long carId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
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
