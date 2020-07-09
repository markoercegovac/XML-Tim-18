package com.team18.WebServiceManager.mq.dto;

import lombok.Data;

@Data
public class PictureMQ {
	protected Long id;
	protected String name;
	protected String base64;
	protected boolean deleted;
}
