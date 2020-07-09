package com.team18.WebServiceManager.ws.dto;

import com.team18.WebServiceManager.ws.WsNameSpace;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

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

}
