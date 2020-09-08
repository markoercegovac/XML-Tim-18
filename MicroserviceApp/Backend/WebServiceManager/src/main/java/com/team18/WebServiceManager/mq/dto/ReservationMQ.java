package com.team18.WebServiceManager.mq.dto;

import java.util.Date;

public class ReservationMQ {

	protected Long id;
	protected Long advertId;
	protected String status;
	protected String userEmail;
	protected String ownerEmail;
	protected Date start;
	protected Date end;

	public ReservationMQ() {
	}

	public ReservationMQ(Long id, Long advertId, String status, String userEmail, Date start, Date end, String ownerEmail) {
		this.id = id;
		this.advertId = advertId;
		this.status = status;
		this.userEmail = userEmail;
		this.start = start;
		this.end = end;
		this.ownerEmail = ownerEmail;
	}

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
