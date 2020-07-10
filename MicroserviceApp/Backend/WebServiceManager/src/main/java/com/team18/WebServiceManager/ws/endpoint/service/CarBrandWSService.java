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

	@PayloadRoot(namespace = WsNameSpace.namespace, localPart = "carBrandRequest")
	@ResponsePayload
	public SoapResponse handleCarBrand(@RequestPayload CarBrandRequest request) {
		Agent ag = agentRepository.findByAgentEmail(request.getToken());
		CarBrand b = carBrandRepository.findByAgentAgentIdAndKeyAG(ag.getAgentId(), request.getId());
		System.out.println("WS CAR BRAND GOT"+request);
		CarBrandMQ mq = new CarBrandMQ();
		mq.setId(b!=null?b.getKeyMS():null);
		mq.setName(request.getName());
		mq.setDeleted(request.isDeleted());

		adProducer.produceCarBrand(mq);

		SoapResponse response = new SoapResponse();
		response.setAgId(ag.getAgentId());
		if(b==null) {
			CarBrand brand = new CarBrand();
			brand.setAgent(ag);
			brand.setKeyAG(request.getId());
			List<CarBrand> sort = carBrandRepository.findByAgentAgentIdOrderByKeyMSDesc(ag.getAgentId());
			if(sort.isEmpty()) {
				brand.setKeyMS(1l);
			} else {
				Long key = sort.get(0).getKeyMS();
				brand.setKeyMS(++key);
			}

			response.setStatus("CREATED");
		} else {
			response.setStatus("UPDATED");
		}
		return response;
//		return null;
	}
}
