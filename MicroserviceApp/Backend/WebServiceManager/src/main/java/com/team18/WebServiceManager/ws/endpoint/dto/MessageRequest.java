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
@XmlType(name = "messageRequest", propOrder = {
		"id",
		"token",
		"header",
		"content",
		"creationDate",
		"senderEmail",
		"receiverEmail"
}, namespace = WsNameSpace.namespace)
public class MessageRequest {

	@XmlElement(required = true)
	protected Long id;

	@XmlElement(required = true)
	protected String token;

	@XmlElement(required = true)
	protected String header;

	@XmlElement(required = true)
	protected String content;

	@XmlElement(required = true)
	@XmlSchemaType(name = "dateTime")
	protected Date creationDate;

	@XmlElement(required = true)
	protected String senderEmail;

	@XmlElement(required = true)
	protected Long receiverEmail;
}
