package com.team18.WebServiceManager.ws.endpoint.service;

import com.team18.WebServiceManager.model.Advert;
import com.team18.WebServiceManager.model.Agent;
import com.team18.WebServiceManager.mq.dto.AdvertMQ;
import com.team18.WebServiceManager.mq.service.producer.AdProducer;
import com.team18.WebServiceManager.repository.AdvertRepository;
import com.team18.WebServiceManager.repository.AgentRepository;
import com.team18.WebServiceManager.ws.WsNameSpace;
import com.team18.WebServiceManager.ws.endpoint.dto.AdvertRequest;
import com.team18.WebServiceManager.ws.endpoint.dto.SoapResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class AdvertWSService {


    @Autowired
    private AdProducer adProducer;
    @Autowired
    private AdvertRepository advertRepository;
    @Autowired
    private AgentRepository agentRepository;

    @PayloadRoot(namespace = WsNameSpace.namespace, localPart = "advertRequest")
    @ResponsePayload
    SoapResponse handleAdvert(@RequestPayload AdvertRequest request) {
        Agent ag = agentRepository.findByAgentEmail(request.getToken());
        Advert advert = advertRepository.findByAgentAgentIdAndKeyAG(ag.getAgentId(), request.getId());
        System.out.println("WS ADVERT GOT"+request);
        AdvertMQ mq = new AdvertMQ();
        mq.setId(advert!=null?advert.getKeyMS():null);
        mq.setCarId(request.getCarId());
        mq.setProfileImgId(request.getProfileImgId());
        mq.setGalleryImgIds(request.getGalleryImgIds());
        mq.setStart(request.getStart());
        mq.setEnd(request.getEnd());
        mq.setDescription(request.getDescription());
        mq.setPriceId(request.getPriceId());
        mq.setCaptureIds(request.getCaptureIds());
        mq.setDeleted(request.isDeleted());

//
        adProducer.produceAdvert(mq);

        SoapResponse response = new SoapResponse();
        response.setAgId(ag.getAgentId());
        if(advert==null) {
            Advert advert1 = new Advert();
            advert1.setAgent(ag);
            advert1.setKeyAG(request.getId());
            List<Advert> sort = advertRepository.findByAgentAgentIdOrderByKeyMSDesc(ag.getAgentId());
            if(sort.isEmpty()) {
                advert1.setKeyMS(1l);
            } else {
                Long key = sort.get(0).getKeyMS();
                advert1.setKeyMS(++key);
            }

            response.setStatus("CREATED");
        } else {
            response.setStatus("UPDATED");
        }
        return response;

    }

}
