package com.team18.WebServiceManager.ws.endpoint.dto;

import com.team18.WebServiceManager.ws.WsNameSpace;

import javax.xml.bind.annotation.*;
import java.util.Date;


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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getSenderEmail() {
		return senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}

	public Long getReceiverEmail() {
		return receiverEmail;
	}

	public void setReceiverEmail(Long receiverEmail) {
		this.receiverEmail = receiverEmail;
	}
}
