package com.team18.WebServiceManager.mq.dto;

public class PriceMQ {

	protected Long id;
	protected String name;
	protected Float pricePerDay;
	protected Float insurancePrice;
	protected Float distanceOverflowPrice;
	protected Float discount;
	protected boolean deleted;
	protected String owner;

	public PriceMQ() {
	}

	public PriceMQ(Long id, String name, Float pricePerDay, Float insurancePrice, Float distanceOverflowPrice, Float discount, boolean deleted, String owner) {
		this.id = id;
		this.name = name;
		this.pricePerDay = pricePerDay;
		this.insurancePrice = insurancePrice;
		this.distanceOverflowPrice = distanceOverflowPrice;
		this.discount = discount;
		this.deleted = deleted;
		this.owner = owner;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPricePerDay(Float pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public void setInsurancePrice(Float insurancePrice) {
		this.insurancePrice = insurancePrice;
	}

	public void setDistanceOverflowPrice(Float distanceOverflowPrice) {
		this.distanceOverflowPrice = distanceOverflowPrice;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Float getPricePerDay() {
		return pricePerDay;
	}

	public Float getInsurancePrice() {
		return insurancePrice;
	}

	public Float getDistanceOverflowPrice() {
		return distanceOverflowPrice;
	}

	public Float getDiscount() {
		return discount;
	}

	public boolean isDeleted() {
		return deleted;
	}
}
