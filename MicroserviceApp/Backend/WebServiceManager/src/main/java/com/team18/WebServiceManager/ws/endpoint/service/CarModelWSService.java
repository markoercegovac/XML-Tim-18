package com.team18.WebServiceManager.ws.endpoint.service;


import com.team18.WebServiceManager.model.Agent;
import com.team18.WebServiceManager.model.CarModel;
import com.team18.WebServiceManager.mq.dto.CarModelMQ;
import com.team18.WebServiceManager.mq.service.producer.AdProducer;
import com.team18.WebServiceManager.repository.AgentRepository;
import com.team18.WebServiceManager.repository.CarModelRepository;
import com.team18.WebServiceManager.ws.WsNameSpace;
import com.team18.WebServiceManager.ws.endpoint.dto.CarModelRequest;
import com.team18.WebServiceManager.ws.endpoint.dto.SoapResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class CarModelWSService {

    @Autowired
    private AdProducer adProducer;
    @Autowired
    private CarModelRepository carModelRepository;
    @Autowired
    private AgentRepository agentRepository;

    @PayloadRoot(namespace = WsNameSpace.namespace, localPart = "carModelRequest")
    @ResponsePayload
    SoapResponse handleCarModel(@RequestPayload CarModelRequest request) {

        Agent ag = agentRepository.findByAgentEmail(request.getToken());
        CarModel model = carModelRepository.findByAgentAgentIdAndKeyAG(ag.getAgentId(), request.getId());
        System.out.println("WS CAR MODEL GOT"+request);
        CarModelMQ mq = new CarModelMQ();
        mq.setId(model!=null?model.getKeyMS():null);
        mq.setName(request.getName());
        mq.setDeleted(request.isDeleted());

//
        adProducer.produceCarModel(mq);

        SoapResponse response = new SoapResponse();
        response.setAgId(ag.getAgentId());
        if(model==null) {
            CarModel cmodel = new CarModel();
            cmodel.setAgent(ag);
            cmodel.setKeyAG(request.getId());
            List<CarModel> sort = carModelRepository.findByAgentAgentIdOrderByKeyMSDesc(ag.getAgentId());
            if(sort.isEmpty()) {
                cmodel.setKeyMS(1l);
            } else {
                Long key = sort.get(0).getKeyMS();
                cmodel.setKeyMS(++key);
            }

            response.setStatus("CREATED");
        } else {
            response.setStatus("UPDATED");
        }
        return response;



    }
}
