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
import org.aspectj.lang.annotation.AfterReturning;
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

    @AfterReturning(value = "execution(* com.example.advertmanagerapp.service.impl.AdvertServiceImpl.createAdvert(..))", returning = "advertModel")
    public void afterSavedCarBrand(JoinPoint joinPoint, Advert advertModel) {

		try {
			Advert ad = adRepository.findById(advertModel.getId()).orElseThrow(NullPointerException::new);

			List<AdSearchReservedDate> reserved = new ArrayList<>();
			if(ad.getCaptures()!=null && !ad.getCaptures().isEmpty()) {
				ad.getCaptures().forEach(capture -> {
					reserved.add(new AdSearchReservedDate(
							capture.getId(),
							capture.getTakeDate(),
							capture.getLeaveDate()));
				});
			}
			AdSearchMQ msg = new AdSearchMQ();
			msg.setAdvertCopyId(ad.getId());
			msg.setCity("Sabac");
			msg.setCarMark(ad.getConcreteCar().getCarBrand().getName());
			msg.setModelMark(ad.getConcreteCar().getCarModel().getModelName());
			msg.setCarFuelType(ad.getConcreteCar().getCarFuelType().getFuelType());
			msg.setCarTransmissionType(ad.getConcreteCar().getCarTransmissionType().getTransmissionType());
			msg.setCarClass(ad.getConcreteCar().getCarClass().getClassName());
			msg.setTraveledKm(ad.getConcreteCar().getTravelDistanceConstraint());
			msg.setInsurance(true);
			msg.setNumberOfSeats(ad.getConcreteCar().getChildrenSitNumber());
			msg.setProfilePicture(null);
			msg.setCarReservationDate(reserved);

			searchProducer.produceMsg(msg);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("ASPECT EXCEPTION IN SEARCH"+ e.getMessage());
		}
    }
}