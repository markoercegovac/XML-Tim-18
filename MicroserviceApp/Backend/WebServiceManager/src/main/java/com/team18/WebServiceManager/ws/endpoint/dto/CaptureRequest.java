package com.team18.WebServiceManager.ws.endpoint.dto;

import com.team18.WebServiceManager.ws.WsNameSpace;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(namespace = WsNameSpace.namespace)
@XmlType(name = "captureRequest", propOrder = {
		"id",
		"token",
		"start",
		"end"
}, namespace = WsNameSpace.namespace)
public class CaptureRequest {

	@XmlElement(required = true)
	protected Long id;

	@XmlElement(required = true)
	protected String token;

	@XmlElement(required = true)
	@XmlSchemaType(name = "dateTime")
	protected Date start;

	@XmlElement(required = true)
	@XmlSchemaType(name = "dateTime")
	protected Date end;

}
