package com.team18.WebServiceManager.ws.endpoint.service;

import com.team18.WebServiceManager.model.Agent;
import com.team18.WebServiceManager.model.Price;
import com.team18.WebServiceManager.mq.dto.PriceMQ;
import com.team18.WebServiceManager.mq.service.producer.AdProducer;
import com.team18.WebServiceManager.repository.AgentRepository;
import com.team18.WebServiceManager.repository.PriceRepository;
import com.team18.WebServiceManager.ws.WsNameSpace;
import com.team18.WebServiceManager.ws.endpoint.dto.PriceRequest;
import com.team18.WebServiceManager.ws.endpoint.dto.SoapResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class PriceWSService {

    @Autowired
    private AdProducer adProducer;
    @Autowired
    private PriceRepository priceRepository;
    @Autowired
    private AgentRepository agentRepository;

    @PayloadRoot(namespace = WsNameSpace.namespace, localPart = "priceRequest")
    @ResponsePayload
    SoapResponse handlePrice(@RequestPayload PriceRequest request) {

        Agent ag = agentRepository.findByAgentEmail(request.getToken());
        Price price = priceRepository.findByAgentAgentIdAndKeyAG(ag.getAgentId(), request.getId());
        System.out.println("WS PRICE GOT"+request);
        PriceMQ mq = new PriceMQ();
        mq.setId(request.getId());
        mq.setName(request.getName());
        mq.setPricePerDay(request.getPricePerDay());
        mq.setDiscount(request.getDiscount());
        mq.setInsurancePrice(request.getInsurancePrice());
        mq.setDistanceOverflowPrice(request.getDistanceOverflowPrice());
        mq.setDeleted(request.isDeleted());
        mq.setOwner(request.getToken());

        adProducer.producePrice(mq);

        SoapResponse response = new SoapResponse();
        response.setAgId(ag.getAgentId());
        if(price==null) {
            Price price1 = new Price();
            price1.setAgent(ag);
            price1.setKeyAG(request.getId());
            List<Price> sort = priceRepository.findByAgentAgentIdOrderByKeyMSDesc(ag.getAgentId());
            if(sort.isEmpty()) {
                price1.setKeyMS(1l);
            } else {
                Long key = sort.get(0).getKeyMS();
                price1.setKeyMS(++key);
            }

            response.setStatus("CREATED");
        } else {
            response.setStatus("UPDATED");
        }
        return response;

    }

}
