package com.example.advertmanagerapp.dto;

import com.example.advertmanagerapp.model.Advert;
import lombok.Data;


import java.util.Set;

@Data
public class PriceDto {


    private Long id;
    private String name;
    private float pricePerDay;
    private float insurancePrice;
    private float distanceOverflowPrice;
    private float discount;
    private boolean isRemoved;
    private Set<Advert> advertSet;
}
