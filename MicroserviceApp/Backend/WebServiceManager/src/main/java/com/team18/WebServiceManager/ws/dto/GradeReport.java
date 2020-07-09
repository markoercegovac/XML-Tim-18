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
@XmlType(name = "gradeReport", propOrder = {
		"id",
		"token",
		"grade",
		"advertId",
		"deleted"
}, namespace = WsNameSpace.namespace)
public class GradeReport {

	@XmlElement(required = true)
	protected Long id;

	@XmlElement(required = true)
	protected String token;

	@XmlElement(required = true)
	protected float grade;

	@XmlElement(required = true)
	protected Long advertId;

	@XmlElement(required = true)
	protected boolean deleted;
}
