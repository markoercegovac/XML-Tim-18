package com.team18.WebServiceManager.mq.dto;

import lombok.Data;
import java.util.Date;

@Data
public class CaptureMQ {

	protected Long id;
	protected Date start;
	protected Date end;
}
