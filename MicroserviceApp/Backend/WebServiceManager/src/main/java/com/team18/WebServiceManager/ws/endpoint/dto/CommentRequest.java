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
@XmlType(name = "commentRequest", propOrder = {
		"id",
		"token",
		"advertId",
		"content",
		"header",
		"creationDate",
		"userEmail"
}, namespace = WsNameSpace.namespace)
public class CommentRequest {

	@XmlElement(required = true)
	protected Long id;

	@XmlElement(required = true)
	protected String token;

	@XmlElement(required = true)
	protected Long advertId;

	@XmlElement(required = true)
	protected String content;

	@XmlElement(required = true)
	protected String header;

	@XmlElement(required = true)
	@XmlSchemaType(name = "dateTime")
	protected Date creationDate;

	@XmlElement(required = true)
	protected String userEmail;
}
