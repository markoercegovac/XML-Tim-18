package com.team18.WebServiceManager.mq.dto;

public class PictureMQ {
	protected Long id;
	protected String name;
	protected String base64;
	protected boolean deleted;

	public PictureMQ() {
	}

	public PictureMQ(Long id, String name, String base64, boolean deleted) {
		this.id = id;
		this.name = name;
		this.base64 = base64;
		this.deleted = deleted;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBase64(String base64) {
		this.base64 = base64;
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

	public String getBase64() {
		return base64;
	}

	public boolean isDeleted() {
		return deleted;
	}
}
