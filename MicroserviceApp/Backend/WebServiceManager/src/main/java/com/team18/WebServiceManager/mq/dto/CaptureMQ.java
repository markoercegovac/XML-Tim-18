package com.team18.WebServiceManager.mq.dto;


import java.util.Date;

public class CaptureMQ {

	protected Long id;
	protected Date start;
	protected Date end;

	public CaptureMQ() {
	}

	public CaptureMQ(Long id, Date start, Date end) {
		this.id = id;
		this.start = start;
		this.end = end;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public Long getId() {
		return id;
	}

	public Date getStart() {
		return start;
	}

	public Date getEnd() {
		return end;
	}
}
