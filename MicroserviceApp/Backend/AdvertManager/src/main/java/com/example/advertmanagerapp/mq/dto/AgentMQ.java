package com.example.advertmanagerapp.mq.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AgentMQ implements Serializable {

	private String url;
	private String email;
}
