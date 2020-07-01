package com.example.advertmanagerapp.dto;

import com.example.advertmanagerapp.dto.mapper.DtoEntity;
import com.example.advertmanagerapp.model.Advert;
import lombok.Data;


import java.util.Set;

@Data
public class PriceDto implements DtoEntity {


    private Long id;
    private String priceName;
    private float pricePerDay;
    private float insurancePrice;
    private float distanceOverflowPrice;
    private float discount;
    private boolean isRemoved;

}
