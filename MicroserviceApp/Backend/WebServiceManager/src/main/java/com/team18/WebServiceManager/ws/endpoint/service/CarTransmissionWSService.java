package com.team18.WebServiceManager.ws.endpoint.service;


import com.team18.WebServiceManager.model.Agent;
import com.team18.WebServiceManager.model.CarTransmission;
import com.team18.WebServiceManager.mq.dto.CarTransmissionMQ;
import com.team18.WebServiceManager.mq.service.producer.AdProducer;
import com.team18.WebServiceManager.repository.AgentRepository;
import com.team18.WebServiceManager.repository.CarTransmissionRepository;
import com.team18.WebServiceManager.ws.WsNameSpace;
import com.team18.WebServiceManager.ws.endpoint.dto.CarTransmissionRequest;
import com.team18.WebServiceManager.ws.endpoint.dto.SoapResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class CarTransmissionWSService {

    @Autowired
    private AdProducer adProducer;
    @Autowired
    private CarTransmissionRepository carTransmissionRepository;
    @Autowired
    private AgentRepository agentRepository;

    @PayloadRoot(namespace = WsNameSpace.namespace, localPart = "carTransmissionRequest")
    @ResponsePayload
    SoapResponse handleCarTransmission(@RequestPayload CarTransmissionRequest request) {


        Agent ag = agentRepository.findByAgentEmail(request.getToken());
        CarTransmission carTransmission = carTransmissionRepository.findByAgentAgentIdAndKeyAG(ag.getAgentId(), request.getId());
        System.out.println("WS CAR BRAND GOT"+request);
        CarTransmissionMQ mq = new CarTransmissionMQ();
        mq.setId(request.getId());
        mq.setName(request.getName());
        mq.setDeleted(request.isDeleted());

//
        adProducer.produceCarTransmission(mq);

        SoapResponse response = new SoapResponse();
        response.setAgId(ag.getAgentId());
        if(carTransmission==null) {
            CarTransmission transmission = new CarTransmission();
            transmission.setAgent(ag);
            transmission.setKeyAG(request.getId());
            List<CarTransmission> sort = carTransmissionRepository.findByAgentAgentIdOrderByKeyMSDesc(ag.getAgentId());
            if(sort.isEmpty()) {
                transmission.setKeyMS(1l);
            } else {
                Long key = sort.get(0).getKeyMS();
                transmission.setKeyMS(++key);
            }

            response.setStatus("CREATED");
        } else {
            response.setStatus("UPDATED");
        }
        return response;



    }


}
