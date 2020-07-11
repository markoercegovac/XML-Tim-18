package com.example.advertmanagerapp.service.impl;

import com.example.advertmanagerapp.dto.CaptureDto;
import com.example.advertmanagerapp.dto.mapper.DtoEntity;
import com.example.advertmanagerapp.dto.mapper.DtoUtils;
import com.example.advertmanagerapp.model.Advert;
import com.example.advertmanagerapp.model.Capture;
import com.example.advertmanagerapp.repository.AdvertRepository;
import com.example.advertmanagerapp.repository.CaptureRepository;
import com.example.advertmanagerapp.service.CaptureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CaptureServiceImplementation implements CaptureService {

    private final CaptureRepository captureRepository;
    private final DtoUtils dtoUtils;
    private final AdvertRepository advertRepository;

    @Override
    public List<DtoEntity> getAdvertCaptures(Long idAdvert) {
        return advertRepository.findById(idAdvert).get().getCaptures().stream().map(c->dtoUtils.convertToDto(c,new CaptureDto())).collect(Collectors.toList());
    }

    @Override
    public Capture createNewCapture(CaptureDto captureDto) {
        Advert advert=advertRepository.findById(captureDto.getAdvertId()).orElse(null);
        Capture capture=(Capture)dtoUtils.convertToEntity(new Capture(), captureDto);
        Capture retCap = captureRepository.save(capture);
        advert.getCaptures().add(capture);
        advertRepository.save(advert);

        return retCap;
    }
}
