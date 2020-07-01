package com.example.advert_search.mq.service;

import java.util.ArrayList;
import java.util.List;

import com.example.advert_search.model.AdvertCopy;
import com.example.advert_search.model.CarReservedDate;
import com.example.advert_search.mq.dto.AdSearchMQ;
import com.example.advert_search.repository.SearchRepository;
import com.google.gson.Gson;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdvertConsumer {
	
	@Autowired
    private Gson gson;
	@Autowired
	private SearchRepository adRepo;

	@RabbitListener(queues="${abbitmq.queue.from.advert}")
    public void recievedMessage(String msg) {
		System.out.println("MQ>>Recieved Message from ad manager: " + msg);
		
		try {
			AdSearchMQ recived = gson.fromJson(msg, AdSearchMQ.class);

			List<CarReservedDate> carReservationDate = new ArrayList<>();
			recived.getCarReservationDate().forEach(reservation -> {
				carReservationDate.add(new CarReservedDate(
					reservation.getCarReservedDateId(),
					reservation.getStartOfAdvert(),
					reservation.getEndOfAdvert(),
					null));
			});

			AdvertCopy ad = new AdvertCopy();
			ad.setAdvertCopyId(recived.getAdvertCopyId());
			ad.setAdvertCopyId(recived.getAdvertCopyId());
			ad.setCity(recived.getCity());
			ad.setCarMark(recived.getCarMark());
			ad.setModelMark(recived.getModelMark());
			ad.setCarFuelType(recived.getCarFuelType());
			ad.setCarTransmissionType(recived.getCarTransmissionType());
			ad.setCarClass(recived.getCarClass());
			ad.setTraveledKm(recived.getTraveledKm());
			ad.setInsurance(recived.isInsurance());
			ad.setNumberOfSeats(recived.getNumberOfSeats());
			ad.setPrice(recived.getPrice());
			ad.setProfilePicture(recived.getProfilePicture());;
			ad.setCarReservedDate(carReservationDate);

			adRepo.save(ad);
		} catch(Exception e) {
			System.out.println("MQ ERROR");
		}
    }
}