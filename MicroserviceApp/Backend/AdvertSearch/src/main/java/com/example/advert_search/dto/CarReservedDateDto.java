package com.example.advert_search.dto;

import com.example.advert_search.dto.mapper.DtoEntity;
import com.example.advert_search.model.AdvertCopy;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@RequiredArgsConstructor
@Data
public class CarReservedDateDto implements DtoEntity {

    private Long carReservedDateId;
    private Date startOfAdvert;
    private Date endOfAdvert;
    private AdvertCopy advertCopy;

    public CarReservedDateDto(Date start, Date end, AdvertCopy advertCopy){
        this.startOfAdvert= start;
        this.endOfAdvert=end;
        this.advertCopy=advertCopy;
    }
}
