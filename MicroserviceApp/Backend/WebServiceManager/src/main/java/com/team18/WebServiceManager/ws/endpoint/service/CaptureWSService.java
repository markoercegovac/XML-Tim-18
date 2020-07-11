package com.team18.WebServiceManager.ws.endpoint.service;

import com.team18.WebServiceManager.model.Agent;
import com.team18.WebServiceManager.model.Capture;
import com.team18.WebServiceManager.mq.dto.CaptureMQ;
import com.team18.WebServiceManager.mq.service.producer.AdProducer;
import com.team18.WebServiceManager.repository.AgentRepository;
import com.team18.WebServiceManager.repository.CaptureRepository;
import com.team18.WebServiceManager.ws.WsNameSpace;
import com.team18.WebServiceManager.ws.endpoint.dto.CaptureRequest;
import com.team18.WebServiceManager.ws.endpoint.dto.SoapResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class CaptureWSService {


    @Autowired
    private AdProducer adProducer;
    @Autowired
    private CaptureRepository captureRepository;
    @Autowired
    private AgentRepository agentRepository;

    @PayloadRoot(namespace = WsNameSpace.namespace, localPart = "captureRequest")
    @ResponsePayload
    SoapResponse handleCapture(@RequestPayload CaptureRequest request) {
        Agent ag = agentRepository.findByAgentEmail(request.getToken());
        Capture capture = captureRepository.findByAgentAgentIdAndKeyAG(ag.getAgentId(), request.getId());
        System.out.println("WS CAPTURE GOT"+request);
        CaptureMQ mq = new CaptureMQ();
        mq.setId(capture!=null?capture.getKeyMS():null);
        mq.setStart(request.getEnd());
        mq.setEnd(request.getEnd());

//
        adProducer.produceCapture(mq);

        SoapResponse response = new SoapResponse();
        response.setAgId(ag.getAgentId());
        if(capture==null) {
            Capture capture1 = new Capture();
            capture1.setAgent(ag);
            capture1.setKeyAG(request.getId());
            List<Capture> sort = captureRepository.findByAgentAgentIdOrderByKeyMSDesc(ag.getAgentId());
            if(sort.isEmpty()) {
                capture1.setKeyMS(1l);
            } else {
                Long key = sort.get(0).getKeyMS();
                capture1.setKeyMS(++key);
            }

            response.setStatus("CREATED");
        } else {
            response.setStatus("UPDATED");
        }
        return response;

    }

}
