package com.team18.WebServiceManager.ws.endpoint.service;

import com.team18.WebServiceManager.model.Agent;
import com.team18.WebServiceManager.model.Comment;
import com.team18.WebServiceManager.model.Reservation;
import com.team18.WebServiceManager.mq.dto.CommentMQ;
import com.team18.WebServiceManager.mq.dto.ReservationMQ;
import com.team18.WebServiceManager.mq.service.producer.ReservationProducer;
import com.team18.WebServiceManager.repository.AdvertRepository;
import com.team18.WebServiceManager.repository.AgentRepository;
import com.team18.WebServiceManager.repository.ReservationRepository;
import com.team18.WebServiceManager.ws.WsNameSpace;
import com.team18.WebServiceManager.ws.endpoint.dto.CommentRequest;
import com.team18.WebServiceManager.ws.endpoint.dto.ReservationRequest;
import com.team18.WebServiceManager.ws.endpoint.dto.SoapResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class ReservationWSService {

	@Autowired
	private ReservationProducer reservationProducer;
	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private AdvertRepository advertRepository;
	@Autowired
	private AgentRepository agentRepository;

	@PayloadRoot(namespace = WsNameSpace.namespace, localPart = "reservationRequest") //MORA MALO POCETNO SLOVO iz ARGUMENTA METODE
	@ResponsePayload
	public SoapResponse handleReservation(@RequestPayload ReservationRequest request) {
		Agent ag = agentRepository.findByAgentEmail(request.getToken());
		Reservation b = reservationRepository.findByAgentAgentIdAndKeyAG(ag.getAgentId(), request.getId());
		System.out.println("WS RESERVATION GOT"+request);
		ReservationMQ mq = new ReservationMQ();
		mq.setId(request.getId());
		mq.setAdvertId(advertRepository.findByAgentAgentIdAndKeyAG(ag.getAgentId(), request.getAdvertId()).getKeyMS());
		mq.setEnd(request.getEnd());
		mq.setStart(request.getStart());
		mq.setStatus(request.getStatus());
		mq.setUserEmail(request.getUserEmail());
		mq.setOwnerEmail(request.getToken());

		reservationProducer.produceReservation(mq);

		SoapResponse response = new SoapResponse();
		response.setAgId(ag.getAgentId());
		if(b==null) {
			Reservation reservation = new Reservation();
			reservation.setAgent(ag);
			reservation.setKeyAG(request.getId());
			List<Reservation> sort = reservationRepository.findByAgentAgentIdOrderByKeyMSDesc(ag.getAgentId());
			if(sort.isEmpty()) {
				reservation.setKeyMS(1l);
			} else {
				Long key = sort.get(0).getKeyMS();
				reservation.setKeyMS(++key);
			}

			reservationRepository.save(reservation);
			response.setStatus("CREATED");
		} else {
			response.setStatus("UPDATED");
		}
		return response;

	}
}
