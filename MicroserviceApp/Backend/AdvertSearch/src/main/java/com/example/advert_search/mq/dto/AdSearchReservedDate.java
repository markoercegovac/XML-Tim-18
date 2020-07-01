package com.example.advert_search.mq.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdSearchReservedDate {
	
	private Long carReservedDateId;
    private Date startOfAdvert;
    private Date endOfAdvert;
}