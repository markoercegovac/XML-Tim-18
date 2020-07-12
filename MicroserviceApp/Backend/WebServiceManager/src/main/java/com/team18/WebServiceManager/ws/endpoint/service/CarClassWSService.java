package com.team18.WebServiceManager.ws.endpoint.service;

import com.team18.WebServiceManager.model.Agent;
import com.team18.WebServiceManager.model.CarClass;
import com.team18.WebServiceManager.mq.dto.CarClassMQ;
import com.team18.WebServiceManager.mq.service.producer.AdProducer;
import com.team18.WebServiceManager.repository.AgentRepository;
import com.team18.WebServiceManager.repository.CarClassRepository;
import com.team18.WebServiceManager.ws.WsNameSpace;
import com.team18.WebServiceManager.ws.endpoint.dto.CarClassRequest;
import com.team18.WebServiceManager.ws.endpoint.dto.SoapResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class CarClassWSService {

    @Autowired
    private AdProducer adProducer;
    @Autowired
    private CarClassRepository carClassRepository;
    @Autowired
    private AgentRepository agentRepository;


    @PayloadRoot(namespace = WsNameSpace.namespace, localPart = "carClassRequest")
    @ResponsePayload
    SoapResponse handleCarClass(@RequestPayload CarClassRequest request) {
        Agent ag = agentRepository.findByAgentEmail(request.getToken());
        CarClass carClass = carClassRepository.findByAgentAgentIdAndKeyAG(ag.getAgentId(), request.getId());
        System.out.println("WS CAR CLASS GOT"+request);
        CarClassMQ mq = new CarClassMQ();
        mq.setId(request.getId());
        mq.setName(request.getName());
        mq.setDeleted(request.isDeleted());


        adProducer.produceCarClass(mq);

        SoapResponse response = new SoapResponse();
        response.setAgId(ag.getAgentId());
        if(carClass==null) {
            CarClass cclass = new CarClass();
            cclass.setAgent(ag);
            cclass.setKeyAG(request.getId());
            List<CarClass> sort = carClassRepository.findByAgentAgentIdOrderByKeyMSDesc(ag.getAgentId());
            if(sort.isEmpty()) {
                cclass.setKeyMS(1l);
            } else {
                Long key = sort.get(0).getKeyMS();
                cclass.setKeyMS(++key);
            }

            response.setStatus("CREATED");
        } else {
            response.setStatus("UPDATED");
        }
        return response;



    }


}
