package com.team18.WebServiceManager.ws.endpoint.dto;

import com.team18.WebServiceManager.ws.WsNameSpace;

import javax.xml.bind.annotation.*;
import java.util.Date;

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

	public Long getAdvertId() {
		return advertId;
	}

	public void setAdvertId(Long advertId) {
		this.advertId = advertId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}
}
