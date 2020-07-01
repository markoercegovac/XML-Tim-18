package com.example.advertmanagerapp.dto;

import com.example.advertmanagerapp.dto.mapper.DtoEntity;
import com.example.advertmanagerapp.model.Advert;
import lombok.Data;

@Data
public class PictureDto implements DtoEntity {

    private Long id;
    private String picture;
    private Long advertId;
    private boolean isDeleted;
    private String path;

}
