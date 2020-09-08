package com.team18.WebServiceManager.mq.dto;

import java.util.Date;
import java.util.Set;


public class AdvertMQ {
	protected Long id;
	protected Long carId;
	protected Long profileImgId;
	protected Set<Long> galleryImgIds;
	protected Date start;
	protected Date end;
	protected String description;
	protected Long priceId;
	protected Set<Long> captureIds;
	protected boolean deleted;

	public AdvertMQ() {
	}

	public AdvertMQ(Long id, Long carId, Long profileImgId, Set<Long> galleryImgIds, Date start, Date end, String description, Long priceId, Set<Long> captureIds, boolean deleted) {
		this.id = id;
		this.carId = carId;
		this.profileImgId = profileImgId;
		this.galleryImgIds = galleryImgIds;
		this.start = start;
		this.end = end;
		this.description = description;
		this.priceId = priceId;
		this.captureIds = captureIds;
		this.deleted = deleted;
	}

	public void setId(Long id) {
		this.id = id;
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
