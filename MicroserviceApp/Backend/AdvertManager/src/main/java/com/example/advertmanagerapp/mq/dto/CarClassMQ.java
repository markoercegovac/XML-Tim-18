package com.example.advertmanagerapp.mq.dto;

import lombok.Data;

@Data
public class CarClassMQ {
	protected Long id;
	private String name;
	private boolean deleted;
}
