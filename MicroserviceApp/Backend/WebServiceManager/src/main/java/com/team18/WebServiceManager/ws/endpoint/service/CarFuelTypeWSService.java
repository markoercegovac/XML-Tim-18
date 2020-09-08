package com.team18.WebServiceManager.ws.endpoint.service;

import com.team18.WebServiceManager.model.Agent;
import com.team18.WebServiceManager.model.CarFuelType;
import com.team18.WebServiceManager.mq.dto.CarFuelTypeMQ;
import com.team18.WebServiceManager.mq.service.producer.AdProducer;
import com.team18.WebServiceManager.repository.AgentRepository;
import com.team18.WebServiceManager.repository.CarFuelTypeRepository;
import com.team18.WebServiceManager.ws.WsNameSpace;
import com.team18.WebServiceManager.ws.endpoint.dto.CarFuelTypeRequest;
import com.team18.WebServiceManager.ws.endpoint.dto.SoapResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class CarFuelTypeWSService {

    @Autowired
    private AdProducer adProducer;
    @Autowired
    private CarFuelTypeRepository carFuelTypeRepository;
    @Autowired
    private AgentRepository agentRepository;

    @PayloadRoot(namespace = WsNameSpace.namespace, localPart = "carFuelTypeRequest")
    @ResponsePayload
    SoapResponse handleCarFuelType(@RequestPayload CarFuelTypeRequest request) {
        Agent ag = agentRepository.findByAgentEmail(request.getToken());
        CarFuelType fuelType = carFuelTypeRepository.findByAgentAgentIdAndKeyAG(ag.getAgentId(), request.getId());
        System.out.println("WS CAR FUEL TYPE GOT"+request);
        CarFuelTypeMQ mq = new CarFuelTypeMQ();
        mq.setId(request.getId());
        mq.setName(request.getName());
        mq.setDeleted(request.isDeleted());

//
        adProducer.produceCarFuelType(mq);

        SoapResponse response = new SoapResponse();
        response.setAgId(ag.getAgentId());
        if(fuelType==null) {
            CarFuelType carFuelType = new CarFuelType();
            carFuelType.setAgent(ag);
            carFuelType.setKeyAG(request.getId());
            List<CarFuelType> sort = carFuelTypeRepository.findByAgentAgentIdOrderByKeyMSDesc(ag.getAgentId());
            if(sort.isEmpty()) {
                carFuelType.setKeyMS(1l);
            } else {
                Long key = sort.get(0).getKeyMS();
                carFuelType.setKeyMS(++key);
            }

            response.setStatus("CREATED");
        } else {
            response.setStatus("UPDATED");
        }
        return response;
    }

}
