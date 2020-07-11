package com.team18.WebServiceManager.mq.dto;


public class CarClassMQ {
	protected Long id;
	private String name;
	private boolean deleted;

	public CarClassMQ() {
	}

	public CarClassMQ(Long id, String name, boolean deleted) {
		this.id = id;
		this.name = name;
		this.deleted = deleted;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public boolean isDeleted() {
		return deleted;
	}
}
