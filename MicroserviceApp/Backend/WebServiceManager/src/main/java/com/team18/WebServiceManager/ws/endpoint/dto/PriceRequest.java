package com.team18.WebServiceManager.ws.endpoint.dto;;

import com.team18.WebServiceManager.ws.WsNameSpace;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(namespace = WsNameSpace.namespace)
@XmlType(name = "priceRequest", propOrder = {
		"id",
		"token",
		"name",
		"pricePerDay",
		"insurancePrice",
		"distanceOverflowPrice",
		"discount",
		"deleted"
}, namespace = WsNameSpace.namespace)
public class PriceRequest {

	@XmlElement(required = true)
	protected Long id;

	@XmlElement(required = true)
	protected String token;

	@XmlElement(required = true)
	protected String name;

	@XmlElement(required = true)
	protected Float pricePerDay;

	@XmlElement(required = true)
	protected Float insurancePrice;

	@XmlElement(required = true)
	protected Float distanceOverflowPrice;

	@XmlElement(required = true)
	protected Float discount;

	@XmlElement(required = true)
	protected boolean deleted;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(Float pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public Float getInsurancePrice() {
		return insurancePrice;
	}

	public void setInsurancePrice(Float insurancePrice) {
		this.insurancePrice = insurancePrice;
	}

	public Float getDistanceOverflowPrice() {
		return distanceOverflowPrice;
	}

	public void setDistanceOverflowPrice(Float distanceOverflowPrice) {
		this.distanceOverflowPrice = distanceOverflowPrice;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}
