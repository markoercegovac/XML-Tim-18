package com.team18.WebServiceManager.ws.dto;

import com.team18.WebServiceManager.ws.WsNameSpace;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

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
}
