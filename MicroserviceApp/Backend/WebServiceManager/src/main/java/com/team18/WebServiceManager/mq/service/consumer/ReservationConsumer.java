package com.team18.WebServiceManager.mq.service.consumer;

import com.google.gson.Gson;
import com.team18.WebServiceManager.model.Agent;
import com.team18.WebServiceManager.model.Comment;
import com.team18.WebServiceManager.model.Reservation;
import com.team18.WebServiceManager.mq.dto.ReservationMQ;
import com.team18.WebServiceManager.repository.AdvertRepository;
import com.team18.WebServiceManager.repository.AgentRepository;
import com.team18.WebServiceManager.repository.ReservationRepository;
import com.team18.WebServiceManager.ws.client.ReservationWSClinet;
import com.team18.WebServiceManager.ws.endpoint.dto.CommentRequest;
import com.team18.WebServiceManager.ws.endpoint.dto.ReservationRequest;
import com.team18.WebServiceManager.ws.endpoint.dto.SoapResponse;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReservationConsumer {

	@Autowired
	private Gson gson;
	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private AgentRepository agentRepository;
	@Autowired
	private ReservationWSClinet ReservationWSClinet;
	@Autowired
	private AdvertRepository advertRepository;

	@RabbitListener(queues="${rabbitmq.queue.soap.request.soap}")
	public void createComment(String msg) {
		ReservationMQ mq = gson.fromJson(msg, ReservationMQ.class);

		List<Agent> agents = agentRepository.findAll();
		agents.forEach(ag -> {
			//SVAKOM AGENTU POSLATI SOAP
			ReservationRequest request = new ReservationRequest();
			Reservation b = reservationRepository.findByAgentAgentIdAndKeyMS(ag.getAgentId(), mq.getId());
			request.setId(b!=null?b.getKeyAG():0);
			request.setToken(ag.getAgentEmail());
			request.setEnd(mq.getEnd());
			request.setStart(mq.getStart());
			request.setStatus(mq.getStatus());
			request.setAdvertId(advertRepository.findByAgentAgentIdAndKeyAG(ag.getAgentId(), mq.getAdvertId()).getKeyAG());
			request.setUserEmail(mq.getUserEmail());

			//POZOVE SE ODGOVARAJUCI KLIENT DA SE POSALJE SOAP
			ReservationWSClinet.setDefaultUri(ag.getAgentUrl());
			SoapResponse response = ReservationWSClinet.handleReservation(request);

			if(b==null) {
				//TREBA DA SE KREIRA
				b = new Reservation();
				b.setAgent(ag);
				b.setKeyMS(mq.getId());
				b.setKeyAG(response.getAgId());//dobijemo u SOAP RESPONSU, agId

				reservationRepository.save(b);
			}
		});
	}
}
