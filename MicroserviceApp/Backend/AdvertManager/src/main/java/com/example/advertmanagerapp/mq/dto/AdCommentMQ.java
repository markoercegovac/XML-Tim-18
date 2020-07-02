package com.example.advertmanagerapp.mq.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdCommentMQ {
	
	private Long id;
    private String ownerEmail;
    private Date startDate;
    private Date endDate;
}