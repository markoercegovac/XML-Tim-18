package com.example.advertmanagerapp.dto;

import com.example.advertmanagerapp.model.OwnersCar;
import com.example.advertmanagerapp.model.ClientCopy;
import com.example.advertmanagerapp.model.Picture;
import com.example.advertmanagerapp.model.Price;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class AdvertDto {


    private Long id;
    private Long carId;
    private String profilePicture;
    private Set<PictureDto> pictureSet;
    private Date startOfAdvert;
    private Date endOfAdvert;
    private String description;
    private boolean isActive;
    private Long priceId;



}
