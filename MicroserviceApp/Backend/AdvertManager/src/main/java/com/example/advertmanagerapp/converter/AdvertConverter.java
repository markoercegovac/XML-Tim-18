package com.example.advertmanagerapp.converter;

import com.example.advertmanagerapp.dto.AdvertDetailDTO;
import com.example.advertmanagerapp.model.Advert;
import com.example.advertmanagerapp.model.Picture;
import com.example.advertmanagerapp.repository.PictureRepository;
import com.example.advertmanagerapp.service.PictureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AdvertConverter {

    private final PictureRepository pictureRepository;
    private final PictureService pictureService;

    public AdvertDetailDTO fromAdvertToAdvertDetail(Advert ad) throws NullPointerException, IOException {

        AdvertDetailDTO ret = new AdvertDetailDTO();
        ret.setAdvertId(ad.getId());
        //ret.setProfilePicture(ad.getProfilePicture());
        List<String> pictures=new ArrayList<>();
        List<Long> idsOfPictures=new ArrayList<>();
        for(Picture p: ad.getPictureSet()){
            idsOfPictures.add(p.getId());
        }

        List<Picture> picList= pictureRepository.findAllById(idsOfPictures);
        Picture profile=new Picture();
        profile.setPath(ad.getProfilePicture());
        pictures.add(pictureService.getPicture(profile));
        for(Picture pi: picList){
            pictures.add(pictureService.getPicture(pi));
        }
        ret.setGallery(pictures);


        //ret.setMileage(ad.getConcreteCar());
        //ret.setMileageUnit(ad.getOwnersCar().getTraveledUnit().toString());
        ret.setDescription(ad.getDescription());
        ret.setPricePerDay(ad.getPrice().getPricePerDay());
        ret.setInsurancePrice(ad.getPrice().getInsurancePrice());
        ret.setDiscount(ad.getPrice().getDiscount());
        ret.setCarBrand(ad.getConcreteCar().getCarBrand().getName());
        ret.setCarClass(ad.getConcreteCar().getCarClass().getClassName());
        ret.setCarFuelType(ad.getConcreteCar().getCarFuelType().getFuelType());
        ret.setCarModel(ad.getConcreteCar().getCarModel().getModelName());
        ret.setCarTransmissionType(ad.getConcreteCar().getCarTransmissionType().getTransmissionType());
        ret.setCarChildSeatNumber(ad.getConcreteCar().getChildrenSitNumber());
        //ret.setCarAvailableDistanceWithoutOverflowPrice((Long)ad.getConcreteCar().getTravelDistanceConstraint());

        return ret;
    }

}
