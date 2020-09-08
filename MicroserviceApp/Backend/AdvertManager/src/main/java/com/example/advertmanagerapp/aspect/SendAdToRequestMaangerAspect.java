package com.example.advertmanagerapp.aspect;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import ch.qos.logback.core.net.server.Client;
import com.example.advertmanagerapp.dto.AdvertDto;
import com.example.advertmanagerapp.model.Advert;
import com.example.advertmanagerapp.model.ClientCopy;
import com.example.advertmanagerapp.mq.dto.AdRequestMQ;
import com.example.advertmanagerapp.mq.dto.AdRequestReservationDateMQ;
import com.example.advertmanagerapp.mq.service.RequestProducer;
import com.example.advertmanagerapp.repository.AdvertRepository;

import com.example.advertmanagerapp.repository.ClientCopyRepository;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SendAdToRequestMaangerAspect {
	
	@Autowired
	private RequestProducer requestProducer;
	@Autowired
	private AdvertRepository adRepo;
	@Autowired
	private ClientCopyRepository clientCopyRepository;

	@After(value = "execution(* com.example.advertmanagerapp.service.impl.AdvertServiceImpl.createAdvert(..)) and args(advertDto)")
	public void sendToRequestManager(AdvertDto advertDto) {

		try {
			Advert a = adRepo.findById(advertDto.getCarId()).orElseThrow(NullPointerException::new);

    		Set<AdRequestReservationDateMQ> carReservedDate = new HashSet<>();

			a.getCaptures().forEach(capture -> {
				carReservedDate.add(new AdRequestReservationDateMQ(
					capture.getId(),
					capture.getTakeDate(),
					capture.getLeaveDate()
				));
			});

			ClientCopy c = clientCopyRepository.findByAdvertsId(a.getId());
			AdRequestMQ msg = new AdRequestMQ();
			msg.setAdvertCopyId(a.getId());
			msg.setOwnerEmail(c.getEmail());
			msg.setAdvertEndDate((Date) a.getEndOfAdvert());
			msg.setCarReservedDate(carReservedDate);

			requestProducer.produceMsg(msg);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("ASPECT ERROR"+ e.getMessage());
		}
	}
}