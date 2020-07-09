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
@XmlType(name = "clientRequest", propOrder = {
		"id",
		"token",
		"email"
}, namespace = WsNameSpace.namespace)
public class ClientRequest {

	@XmlElement(required = true)
	protected Long id;

	@XmlElement(required = true)
	protected String token;

	@XmlElement(required = true)
	protected String email;
}
