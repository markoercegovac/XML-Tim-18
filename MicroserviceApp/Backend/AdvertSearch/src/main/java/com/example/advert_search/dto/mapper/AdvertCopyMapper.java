package com.example.advert_search.dto.mapper;

import com.example.advert_search.dto.AdvertCopyDto;
import com.example.advert_search.model.AdvertCopy;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class AdvertCopyMapper {

    public AdvertCopyDto AdvertToAdvertDto(AdvertCopy advertCopy){
        AdvertCopyDto advertCopyDto = new AdvertCopyDto();
        advertCopyDto.setAdvertCopyId(advertCopy.getAdvertCopyId());
        advertCopyDto.setCity(advertCopy.getCity());
        advertCopyDto.setCarMark(advertCopy.getCarMark());
        advertCopyDto.setModelMark(advertCopy.getModelMark());
        advertCopyDto.setCarFuelType(advertCopy.getCarFuelType());
        advertCopyDto.setCarTransmissionType(advertCopy.getCarTransmissionType());
        advertCopyDto.setCarClass(advertCopy.getCarClass());
        advertCopyDto.setPriceFrom(advertCopy.getPriceFrom());
        advertCopyDto.setPriceTo(advertCopy.getPriceTo());
        advertCopyDto.setTraveledKm(advertCopy.getTraveledKm());
        advertCopyDto.setPlannedKm(advertCopy.getPlannedKm());
        advertCopyDto.setInsurance(advertCopy.getInsurance());
        advertCopyDto.setNumberOfSeats(advertCopy.getNumberOfSeats());
        advertCopyDto.setProfilePicture(advertCopy.getProfilePicture());
        advertCopyDto.setMark(advertCopy.getMark());
        advertCopyDto.setPrice(advertCopy.getPrice());
        advertCopyDto.setCarReservedDate(advertCopy.getCarReservedDate());

        return advertCopyDto;
    }

    public AdvertCopy AdvertDtoToAdvert(AdvertCopyDto advertCopyDto){
        AdvertCopy advertCopy = new AdvertCopy();
        advertCopy.setAdvertCopyId(advertCopyDto.getAdvertCopyId());
        advertCopy.setCity(advertCopyDto.getCity());
        advertCopy.setCarMark(advertCopyDto.getCarMark());
        advertCopy.setModelMark(advertCopyDto.getModelMark());
        advertCopy.setCarFuelType(advertCopyDto.getCarFuelType());
        advertCopy.setCarTransmissionType(advertCopyDto.getCarTransmissionType());
        advertCopy.setCarClass(advertCopyDto.getCarClass());
        advertCopy.setPriceFrom(advertCopyDto.getPriceFrom());
        advertCopy.setPriceTo(advertCopyDto.getPriceTo());
        advertCopy.setTraveledKm(advertCopyDto.getTraveledKm());
        advertCopy.setPlannedKm(advertCopyDto.getPlannedKm());
        advertCopy.setInsurance(advertCopyDto.getInsurance());
        advertCopy.setNumberOfSeats(advertCopyDto.getNumberOfSeats());
        advertCopy.setProfilePicture(advertCopyDto.getProfilePicture());
        advertCopy.setMark(advertCopyDto.getMark());
        advertCopy.setPrice(advertCopyDto.getPrice());
        advertCopy.setCarReservedDate(advertCopyDto.getCarReservedDate());

        return advertCopy;
    }
}
