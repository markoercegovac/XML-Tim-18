package com.team18.WebServiceManager.ws.dto;

import com.team18.WebServiceManager.ws.WsNameSpace;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

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
}
