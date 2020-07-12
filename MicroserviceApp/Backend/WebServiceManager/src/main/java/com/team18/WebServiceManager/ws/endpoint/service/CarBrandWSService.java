package com.team18.WebServiceManager.ws.endpoint.service;

import com.team18.WebServiceManager.model.Agent;
import com.team18.WebServiceManager.model.CarBrand;
import com.team18.WebServiceManager.mq.dto.CarBrandMQ;
import com.team18.WebServiceManager.mq.service.producer.AdProducer;
import com.team18.WebServiceManager.repository.AgentRepository;
import com.team18.WebServiceManager.repository.CarBrandRepository;
import com.team18.WebServiceManager.ws.WsNameSpace;
import com.team18.WebServiceManager.ws.endpoint.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import java.util.List;

@Endpoint
public class CarBrandWSService {

	@Autowired
	private AdProducer adProducer;
	@Autowired
	private CarBrandRepository carBrandRepository;
	@Autowired
	private AgentRepository agentRepository;

	@PayloadRoot(namespace = WsNameSpace.namespace, localPart = "carBrandRequest") //ime klase iz argumenta metode ali obavezno ide MALO pocetno slovo
	@ResponsePayload //ove dve anotacije jako bitne
	public SoapResponse handleCarBrand(@RequestPayload CarBrandRequest request) {
		Agent ag = agentRepository.findByAgentEmail(request.getToken()); //nadjem agenta koji je poslao poruku(token uvek agent)
		CarBrand b = carBrandRepository.findByAgentAgentIdAndKeyAG(ag.getAgentId(), request.getId()); //gledam da li imam kljuc agentski(da li je taj entitet vec bio razmenjivan)
		System.out.println("WS CAR BRAND GOT"+request);
		CarBrandMQ mq = new CarBrandMQ();
		mq.setId(request.getId()); //ovde je null, a u Consumeru je 0
		mq.setName(request.getName());
		mq.setDeleted(request.isDeleted()); //sve dovde konverija iz requesta u mq

		adProducer.produceCarBrand(mq); //prima mq objekat gore napravljen

		SoapResponse response = new SoapResponse(); //formira se porukaa
		response.setAgId(ag.getAgentId()); //agent koji nam je poslao poruku, njemu cemo i odgovoriti
		if(b==null) {
			CarBrand brand = new CarBrand();
			brand.setAgent(ag);
			brand.setKeyAG(request.getId());
			List<CarBrand> sort = carBrandRepository.findByAgentAgentIdOrderByKeyMSDesc(ag.getAgentId()); //pokusavamo da nadjemo sve entitete za tog agenta,ako ne nadjemo, stavljamo id=1, ako lista nije prazna, nadjemo poslednji i samo uvecamo id
			if(sort.isEmpty()) {
				brand.setKeyMS(1l);
			} else {
				Long key = sort.get(0).getKeyMS();
				brand.setKeyMS(++key);
			}
			carBrandRepository.save(brand);

			response.setStatus("CREATED");
		} else {
			response.setStatus("UPDATED");
		}
		return response;
	}
}
