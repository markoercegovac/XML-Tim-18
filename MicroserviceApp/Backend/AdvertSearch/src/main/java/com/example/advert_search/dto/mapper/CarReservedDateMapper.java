package com.example.advert_search.dto.mapper;

import com.example.advert_search.dto.AdvertCopyDto;
import com.example.advert_search.dto.CarReservedDateDto;
import com.example.advert_search.model.CarReservedDate;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CarReservedDateMapper {

    public CarReservedDateDto CarReservedToDto(CarReservedDate carReservedDate){
        CarReservedDateDto carReservedDateDto = new CarReservedDateDto();
        carReservedDateDto.setCarReservedDateId(carReservedDate.getCarReservedDateId());
        carReservedDateDto.setStartOfAdvert(carReservedDate.getStartOfAdvert());
        carReservedDateDto.setEndOfAdvert(carReservedDate.getEndOfAdvert());
        carReservedDateDto.setAdvertCopy(carReservedDate.getAdvertCopy());

        return carReservedDateDto;
    }

    public CarReservedDate DtoToCarReserved(CarReservedDateDto carReservedDateDto){
        CarReservedDate carReservedDate = new CarReservedDate();
        carReservedDate.setCarReservedDateId(carReservedDateDto.getCarReservedDateId());
        carReservedDate.setStartOfAdvert(carReservedDateDto.getStartOfAdvert());
        carReservedDate.setEndOfAdvert(carReservedDateDto.getEndOfAdvert());
        carReservedDate.setAdvertCopy(carReservedDateDto.getAdvertCopy());

        return carReservedDate;
    }
}
