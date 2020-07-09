package com.team18.WebServiceManager.ws.dto;

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
}
