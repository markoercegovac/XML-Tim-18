package com.example.advertmanagerapp.dto;

import com.example.advertmanagerapp.model.Advert;
import lombok.Data;

@Data
public class PictureDto {

    private Long id;
    private String picture;
    private Advert advert;
    private boolean isDeleted;
}
