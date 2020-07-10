package com.team18.WebServiceManager.ws.endpoint.dto;

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
@XmlType(name = "pictureRequest", propOrder = {
		"id",
		"token",
		"name",
		"base64",
		"deleted"
}, namespace = WsNameSpace.namespace)
public class PictureRequest {

	@XmlElement(required = true)
	protected Long id;

	@XmlElement(required = true)
	protected String token;

	@XmlElement(required = true)
	protected String name;

	@XmlElement(required = true)
	protected String base64;

	@XmlElement(required = true)
	protected boolean deleted;
}
