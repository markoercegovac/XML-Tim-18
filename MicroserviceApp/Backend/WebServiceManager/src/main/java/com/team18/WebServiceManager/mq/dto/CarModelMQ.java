package com.team18.WebServiceManager.mq.dto;

import lombok.Data;

@Data
public class CarModelMQ {
	protected Long id;
	private String name;
	private boolean deleted;
}
