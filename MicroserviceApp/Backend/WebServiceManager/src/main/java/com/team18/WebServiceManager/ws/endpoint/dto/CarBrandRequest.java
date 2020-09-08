package com.team18.WebServiceManager.ws.endpoint.dto;

import com.team18.WebServiceManager.ws.WsNameSpace;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(namespace = WsNameSpace.namespace)
@XmlType(name = "carBrandRequest", propOrder = {
		"id",
		"token",
		"name",
		"deleted"
}, namespace = WsNameSpace.namespace)
public class CarBrandRequest {

	@XmlElement(required = true)
	protected Long id;

	@XmlElement(required = true)
	protected String token;

	@XmlElement(required = true)
	protected String name;

	@XmlElement(required = true)
	protected boolean deleted;

	public Long getId() {
		return id;
	}

	public String getToken() {
		return token;
	}

	public String getName() {
		return name;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}
