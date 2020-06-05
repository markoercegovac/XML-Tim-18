package com.example.advertmanagerapp.dto;

import com.example.advertmanagerapp.dto.mapper.DtoEntity;
import lombok.Data;

import java.util.Date;

@Data
public class CaptureDto implements DtoEntity {
    private Long id;
    private Date takeDate;
    private Date leaveDate;
    private Long advertId;
}
