package com.team18.WebServiceManager.ws.endpoint.dto;

import com.team18.WebServiceManager.ws.WsNameSpace;
import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(namespace = WsNameSpace.namespace)
@XmlType(name = "soapResponse", propOrder = {
		"status",
		"agId"
}, namespace = WsNameSpace.namespace)
public class SoapResponse {

	@XmlElement(required = true)
	protected String status;

	@XmlElement(required = true)
	protected Long agId;

	public String getStatus() {
		return status;
	}

	public Long getAgId() {
		return agId;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setAgId(Long agId) {
		this.agId = agId;
	}
}
