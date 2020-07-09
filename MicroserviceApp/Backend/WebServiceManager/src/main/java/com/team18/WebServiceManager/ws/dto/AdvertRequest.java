package com.team18.WebServiceManager.ws.dto;

import com.team18.WebServiceManager.ws.WsNameSpace;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor

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
}
