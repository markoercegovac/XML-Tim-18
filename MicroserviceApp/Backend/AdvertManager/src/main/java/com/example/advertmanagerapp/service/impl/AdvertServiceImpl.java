package com.example.advertmanagerapp.service.impl;

import com.example.advertmanagerapp.converter.AdvertConverter;
import com.example.advertmanagerapp.dto.AdvertDetailDTO;
import com.example.advertmanagerapp.dto.PictureDto;
import com.example.advertmanagerapp.model.Advert;
import com.example.advertmanagerapp.repository.AdvertRepository;
import com.example.advertmanagerapp.dto.AdvertDto;
import com.example.advertmanagerapp.dto.mapper.DtoEntity;
import com.example.advertmanagerapp.dto.mapper.DtoUtils;
import com.example.advertmanagerapp.model.*;


import com.example.advertmanagerapp.repository.ConcreteCarRepository;
import com.example.advertmanagerapp.repository.PictureRepository;
import com.example.advertmanagerapp.repository.PriceRepository;
import com.example.advertmanagerapp.service.AdvertService;
import com.example.advertmanagerapp.service.PictureService;
import com.example.advertmanagerapp.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdvertServiceImpl implements AdvertService {

    private final AdvertRepository advertRepository;
    private final DtoUtils dtoUtils;
    private final PictureService pictureService;
    private final PriceService priceService;
    private final PictureRepository pictureRepository;
    private final PriceRepository priceRepository;
    private final ConcreteCarRepository concreteCarRepository;

    public AdvertDetailDTO detailAdForClient(Long advertId) {

        try {
            Advert foundAd = advertRepository.findByIdAndIsActiveTrue(advertId).orElse(null);
            if (foundAd != null) {
                return AdvertConverter.fromAdvertToAdvertDetail(foundAd);
            } else {
                return null;
            }
        } catch (NullPointerException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void createAdvert(AdvertDto advertDto) throws IOException {
        Advert advert= (Advert) dtoUtils.convertToEntity(new Advert(),advertDto);
        pictureService.savePicture(advertDto.getProfilePicture());
        advertDto.getPictureSet().forEach(p->{
            try {
                pictureService.savePicture(p);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        List<Picture> pictureList=new ArrayList<>();
        advertDto.getPictureSet().forEach(p->{
            Picture picture=new Picture();
            picture.setPath(p.getPath());
            pictureList.add(picture);
        });
        advert.setPictureSet(pictureList);
        advert.setProfilePicture(advertDto.getProfilePicture().getPath());
        Price price=priceRepository.findById(advertDto.getPriceId()).get();
        advert.setPrice(price);
        ConcreteCar concreteCar= concreteCarRepository.findById(advertDto.getCarId()).get();
        advert.setConcreteCar(concreteCar);
        Picture profilePicture= new Picture();
        profilePicture.setPath(advertDto.getProfilePicture().getPath());
        pictureRepository.save(profilePicture);
        advertRepository.save(advert);

    }

    @Override
    public List<DtoEntity> allAdverts() {
        return advertRepository.findAll().stream().map(a->dtoUtils.convertToDto(a,new AdvertDto())).collect(Collectors.toList());
    }

}
