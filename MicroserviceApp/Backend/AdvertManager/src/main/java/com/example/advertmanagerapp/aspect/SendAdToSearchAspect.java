package com.example.advertmanagerapp.aspect;

import java.util.ArrayList;
import java.util.List;

import com.example.advertmanagerapp.dto.AdvertDto;
import com.example.advertmanagerapp.model.Advert;
import com.example.advertmanagerapp.mq.dto.AdSearchMQ;
import com.example.advertmanagerapp.mq.dto.AdSearchReservedDate;
import com.example.advertmanagerapp.mq.service.SearchProducer;
import com.example.advertmanagerapp.repository.AdvertRepository;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SendAdToSearchAspect {
	
	@Autowired
    private SearchProducer searchProducer;
	@Autowired
	private AdvertRepository adRepository;

    @After(value = "execution(* com.example.advertmanagerapp.service.impl.AdvertServiceImpl.createAdvert(..)) and args(advertDto)")
    public void afterSavedCarBrand(JoinPoint joinPoint, AdvertDto advertDto ) {

		try {
			Advert ad = adRepository.findById(advertDto.getId()).orElseThrow(NullPointerException::new);
			List<AdSearchReservedDate> reserved = new ArrayList<>();
			ad.getCaptures().forEach(capture -> {
				reserved.add(new AdSearchReservedDate(
					capture.getId(),
					capture.getTakeDate(),
					capture.getLeaveDate()));
			});

			AdSearchMQ msg = new AdSearchMQ();
			msg.setAdvertCopyId(ad.getId());
//			msg.setCity(ad.getClient().getCity());
//			msg.setCarMark(ad.getOwnersCar().getConcreteCar().getCarBrand().getName());
//			msg.setModelMark(ad.getOwnersCar().getConcreteCar().getCarModel().getModelName());
//			msg.setCarFuelType(ad.getOwnersCar().getConcreteCar().getCarFuelType().getFuelType());
//			msg.setCarTransmissionType(ad.getOwnersCar().getConcreteCar().getCarTransmissionType().getTransmissionType());
//			msg.setCarClass(ad.getOwnersCar().getConcreteCar().getCarClass().getClassName());
//			msg.setTraveledKm(ad.getOwnersCar().getMileage());
//			msg.setInsurance(ad.getOwnersCar().isInsurance());
//			msg.setNumberOfSeats(ad.getOwnersCar().getChildrenSitNumber());
			msg.setProfilePicture(null);
			msg.setCarReservationDate(reserved);

			searchProducer.produceMsg(msg);
		} catch(Exception e) {
			System.out.println("ASPECT EXCEPTION");
		}
    }
}