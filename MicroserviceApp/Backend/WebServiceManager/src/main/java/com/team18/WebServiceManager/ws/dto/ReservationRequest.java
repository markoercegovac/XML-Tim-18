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
@XmlType(name = "reservationRequest", propOrder = {
		"id",
		"token",
		"advertId",
		"status",
		"userEmail",
		"start",
		"end"
}, namespace = WsNameSpace.namespace)
public class ReservationRequest {

	@XmlElement(required = true)
	protected Long id;

	@XmlElement(required = true)
	protected String token;

	@XmlElement(required = true)
	protected Long advertId;

	@XmlElement(required = true)
	protected String status;

	@XmlElement(required = true)
	protected String userEmail;

	@XmlElement(required = true)
	@XmlSchemaType(name = "dateTime")
	protected Date start;

	@XmlElement(required = true)
	@XmlSchemaType(name = "dateTime")
	protected Date end;
}
