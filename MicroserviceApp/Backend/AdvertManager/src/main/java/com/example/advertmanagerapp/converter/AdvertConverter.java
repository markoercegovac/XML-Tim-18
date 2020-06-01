package com.example.advertmanagerapp.converter;

import com.example.advertmanagerapp.dto.AdvertDetailDTO;
import com.example.advertmanagerapp.model.Advert;

import java.util.ArrayList;
import java.util.List;

public abstract class AdvertConverter {

    public static AdvertDetailDTO fromAdvertToAdvertDetail(Advert ad) throws NullPointerException {

        AdvertDetailDTO ret = new AdvertDetailDTO();
        ret.setAdvertId(ad.getId());
        ret.setProfilePicture(ad.getProfilePicture());

        List<String> galleryPic = new ArrayList<String>();
        if(ad.getPictureSet()!=null && ad.getPictureSet().size()>0) {
            ad.getPictureSet().forEach(picture -> {
                galleryPic.add(picture.getPicture());
            });
        }
        ret.setGallery(galleryPic.toArray(new String[galleryPic.size()]));

        ret.setDescription(ad.getDescription());
        ret.setPricePerDay(ad.getPrice().getPricePerDay());
        ret.setInsurancePrice(ad.getPrice().getInsurancePrice());
        ret.setDiscount(ad.getPrice().getDiscount());
        ret.setCarBrand(ad.getOwnersCar().getConcreteCar().getCarBrand().getName());
        ret.setCarClass(ad.getOwnersCar().getConcreteCar().getCarClass().getClassName());
        ret.setCarFuelType(ad.getOwnersCar().getConcreteCar().getCarFuelType().getFuelType());
        ret.setCarModel(ad.getOwnersCar().getConcreteCar().getCarModel().getModelName());
        ret.setCarTransmissionType(ad.getOwnersCar().getConcreteCar().getCarTransmissionType().getTransmissionType());
        ret.setCarChildSeatNumber(ad.getOwnersCar().getChildrenSitNumber());
        ret.setCarAvailableDistanceWithoutOverflowPrice(ad.getOwnersCar().getTravelDistanceConstraint());

        return ret;
    }

}
