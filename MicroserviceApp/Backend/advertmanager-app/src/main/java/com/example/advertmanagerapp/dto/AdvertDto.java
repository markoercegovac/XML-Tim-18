package com.example.advertmanagerapp.dto;

import com.example.advertmanagerapp.model.Car;
import com.example.advertmanagerapp.model.ClientCopy;
import com.example.advertmanagerapp.model.Picture;
import com.example.advertmanagerapp.model.Price;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
public class AdvertDto {


    private Long id;
    private Car car;
    private String profilePicture;
    private Set<Picture> pictureSet;
    private ClientCopy client;
    private Date startOfAdvert;
    private Date endOfAdvert;
    private String description;
    private boolean isActive;
    private Price price;
    private ClientCopy currentDriver;

}
