package com.team18.WebServiceManager.mq.dto;


import java.io.Serializable;

public class AgentMQ implements Serializable {

	private String url;
	private String email;

	public AgentMQ() {
	}

	public AgentMQ(String url, String email) {
		this.url = url;
		this.email = email;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrl() {
		return url;
	}

	public String getEmail() {
		return email;
	}
}
