package com.example.advertmanagerapp.service.impl;

import com.example.advertmanagerapp.converter.AdvertConverter;
import com.example.advertmanagerapp.dto.AdvertCartDTO;
import com.example.advertmanagerapp.dto.AdvertDetailDTO;
import com.example.advertmanagerapp.model.Advert;
import com.example.advertmanagerapp.repository.*;
import com.example.advertmanagerapp.dto.AdvertDto;
import com.example.advertmanagerapp.dto.mapper.DtoEntity;
import com.example.advertmanagerapp.dto.mapper.DtoUtils;
import com.example.advertmanagerapp.model.*;


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
    private final ClientCopyRepository clientCopyRepository;

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
        advert.setActive(true);
        Picture profilePicture= new Picture();
        profilePicture.setPath(advertDto.getProfilePicture().getPath());
        pictureRepository.save(profilePicture);
//        advertRepository.save(advert);

        ClientCopy clientCopy = clientCopyRepository.findByEmail(advertDto.getEmail());
        if(clientCopy.getAdverts() != null) {
            clientCopy.getAdverts().add(advert);
        } else {
            List<Advert> ads = new ArrayList<>();
            ads.add(advert);
            clientCopy.setAdverts(ads);
        }


        clientCopyRepository.save(clientCopy);
    }

    @Override
    public List<DtoEntity> allAdverts() {
        return advertRepository.findAll().stream().map(a->dtoUtils.convertToDto(a,new AdvertDto())).collect(Collectors.toList());
    }

    @Override
    public AdvertCartDTO detailAdForCart(Long adId) {
        try {
            Advert foundAd = advertRepository.findByIdAndIsActiveTrue(adId).orElse(null);
            if (foundAd != null) {
                AdvertCartDTO ret = new AdvertCartDTO();
                ret.setAdvertId(foundAd.getId());
                ret.setEndDate(foundAd.getEndOfAdvert());
                ret.setStartDate(foundAd.getStartOfAdvert());
                float price = foundAd.getPrice().getDiscount()!=0?
                        (foundAd.getPrice().getPricePerDay() * foundAd.getPrice().getDiscount() * 0.01f):
                        foundAd.getPrice().getPricePerDay();
                ret.setPrice(price);
                ret.setProfileImage(foundAd.getProfilePicture());
                ClientCopy c = clientCopyRepository.findByAdvertsId(adId);

                ret.setOwnerEmail(c.getEmail());

                return ret;
            } else {
                return null;
            }
        } catch (NullPointerException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }

}
