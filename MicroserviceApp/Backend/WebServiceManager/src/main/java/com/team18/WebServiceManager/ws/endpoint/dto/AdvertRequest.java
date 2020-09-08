package com.team18.WebServiceManager.ws.endpoint.dto;

import com.team18.WebServiceManager.ws.WsNameSpace;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.Set;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(namespace = WsNameSpace.namespace)
@XmlType(name = "advertRequest", propOrder = {
		"id",
		"token",
		"carId",
		"profileImgId",
		"galleryImgIds",
		"start",
		"end",
		"description",
		"priceId",
		"captureIds",
		"deleted"
}, namespace = WsNameSpace.namespace)
public class AdvertRequest {

	@XmlElement(required = true)
	protected Long id;

	@XmlElement(required = true)
	protected String token;

	@XmlElement(required = true)
	protected Long carId;

	@XmlElement(required = true)
	protected Long profileImgId;

	@XmlElement(required = true)
	protected Set<Long> galleryImgIds;

	@XmlElement(required = true)
	@XmlSchemaType(name = "dateTime")
	protected Date start;

	@XmlElement(required = true)
	@XmlSchemaType(name = "dateTime")
	protected Date end;

	@XmlElement(required = true)
	protected String description;

	@XmlElement(required = true)
	protected Long priceId;

	@XmlElement(required = true)
	protected Set<Long> captureIds;

	@XmlElement(required = true)
	protected boolean deleted;

	public void setId(Long id) {
		this.id = id;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public void setProfileImgId(Long profileImgId) {
		this.profileImgId = profileImgId;
	}

	public void setGalleryImgIds(Set<Long> galleryImgIds) {
		this.galleryImgIds = galleryImgIds;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPriceId(Long priceId) {
		this.priceId = priceId;
	}

	public void setCaptureIds(Set<Long> captureIds) {
		this.captureIds = captureIds;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Long getId() {
		return id;
	}

	public String getToken() {
		return token;
	}

	public Long getCarId() {
		return carId;
	}

	public Long getProfileImgId() {
		return profileImgId;
	}

	public Set<Long> getGalleryImgIds() {
		return galleryImgIds;
	}

	public Date getStart() {
		return start;
	}

	public Date getEnd() {
		return end;
	}

	public String getDescription() {
		return description;
	}

	public Long getPriceId() {
		return priceId;
	}

	public Set<Long> getCaptureIds() {
		return captureIds;
	}

	public boolean isDeleted() {
		return deleted;
	}
}
