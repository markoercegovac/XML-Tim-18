package com.team18.WebServiceManager.ws.endpoint.service;


import com.team18.WebServiceManager.model.Agent;
import com.team18.WebServiceManager.model.Picture;
import com.team18.WebServiceManager.mq.dto.PictureMQ;
import com.team18.WebServiceManager.mq.service.producer.AdProducer;
import com.team18.WebServiceManager.repository.AgentRepository;
import com.team18.WebServiceManager.repository.PictureRepository;
import com.team18.WebServiceManager.ws.WsNameSpace;
import com.team18.WebServiceManager.ws.endpoint.dto.PictureRequest;
import com.team18.WebServiceManager.ws.endpoint.dto.SoapResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class PictureWSService {


    @Autowired
    private AdProducer adProducer;
    @Autowired
    private PictureRepository pictureRepository;
    @Autowired
    private AgentRepository agentRepository;


    @PayloadRoot(namespace = WsNameSpace.namespace, localPart = "pictureRequest")
    @ResponsePayload
    SoapResponse handlePicture(@RequestPayload PictureRequest request) {

        Agent ag = agentRepository.findByAgentEmail(request.getToken());
        Picture picture = pictureRepository.findByAgentAgentIdAndKeyAG(ag.getAgentId(), request.getId());
        System.out.println("WS PICTURE GOT"+request);
        PictureMQ mq = new PictureMQ();
        mq.setId(request.getId());
        mq.setName(request.getName());
        mq.setBase64(request.getBase64());
        mq.setDeleted(request.isDeleted());

//
        adProducer.producePicture(mq);

        SoapResponse response = new SoapResponse();
        response.setAgId(ag.getAgentId());
        if(picture==null) {
            Picture picture1 = new Picture();
            picture1.setAgent(ag);
            picture1.setKeyAG(request.getId());
            List<Picture> sort = pictureRepository.findByAgentAgentIdOrderByKeyMSDesc(ag.getAgentId());
            if(sort.isEmpty()) {
                picture1.setKeyMS(1l);
            } else {
                Long key = sort.get(0).getKeyMS();
                picture1.setKeyMS(++key);
            }

            response.setStatus("CREATED");
        } else {
            response.setStatus("UPDATED");
        }
        return response;
    }
}
