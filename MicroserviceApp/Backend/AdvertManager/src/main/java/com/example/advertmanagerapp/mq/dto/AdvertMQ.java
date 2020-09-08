package com.example.advertmanagerapp.mq.dto;

import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class AdvertMQ {
	protected Long id;
	protected Long carId;
	protected Long profileImgId;
	protected Set<Long> galleryImgIds;
	protected Date start;
	protected Date end;
	protected String description;
	protected Long priceId;
	protected Set<Long> captureIds;
	protected boolean deleted;
}
