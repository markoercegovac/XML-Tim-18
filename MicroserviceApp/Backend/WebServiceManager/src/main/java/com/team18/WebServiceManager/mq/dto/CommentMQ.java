package com.team18.WebServiceManager.mq.dto;

import java.util.Date;

public class CommentMQ {

	protected Long id;
	protected Long advertId;
	protected String content;
	protected String header;
	protected Date creationDate;
	protected String userEmail;

	public CommentMQ(Long id) {
		this.id = id;
	}

	public CommentMQ() {
	}

	public CommentMQ(Long id, Long advertId, String content, String header, Date creationDate, String userEmail) {
		this.id = id;
		this.advertId = advertId;
		this.content = content;
		this.header = header;
		this.creationDate = creationDate;
		this.userEmail = userEmail;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAdvertId() {
		return advertId;
	}

	public void setAdvertId(Long advertId) {
		this.advertId = advertId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
}
