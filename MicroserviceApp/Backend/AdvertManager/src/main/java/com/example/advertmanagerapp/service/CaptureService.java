package com.example.advertmanagerapp.service;

import com.example.advertmanagerapp.dto.CaptureDto;
import com.example.advertmanagerapp.dto.mapper.DtoEntity;
import com.example.advertmanagerapp.model.Capture;

import java.util.List;

public interface CaptureService {
    List<DtoEntity> getAdvertCaptures(Long idAdvert);
    void createNewCapture(CaptureDto captureDto);
}
