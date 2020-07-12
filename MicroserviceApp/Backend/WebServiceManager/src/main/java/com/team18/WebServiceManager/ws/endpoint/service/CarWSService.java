package com.team18.WebServiceManager.ws.endpoint.service;

import com.team18.WebServiceManager.model.Agent;
import com.team18.WebServiceManager.model.Car;
import com.team18.WebServiceManager.mq.dto.CarMQ;
import com.team18.WebServiceManager.mq.service.producer.AdProducer;
import com.team18.WebServiceManager.repository.AgentRepository;
import com.team18.WebServiceManager.repository.CarRepository;
import com.team18.WebServiceManager.ws.WsNameSpace;
import com.team18.WebServiceManager.ws.endpoint.dto.CarRequest;
import com.team18.WebServiceManager.ws.endpoint.dto.SoapResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class CarWSService {

    @Autowired
    private AdProducer adProducer;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private AgentRepository agentRepository;

    @PayloadRoot(namespace = WsNameSpace.namespace, localPart = "carRequest")
    @ResponsePayload
    SoapResponse handleCar(@RequestPayload CarRequest request){

        Agent ag = agentRepository.findByAgentEmail(request.getToken());
        Car car = carRepository.findByAgentAgentIdAndKeyAG(ag.getAgentId(), request.getId());
        System.out.println("WS CAR GOT"+request);
        CarMQ mq = new CarMQ();
        mq.setId(request.getId());
        mq.setCarBrandId(request.getCarBrandId());
        mq.setCarClassId(request.getCarClassId());
        mq.setCarFuelTypeId(request.getCarFuelTypeId());
        mq.setCarTransmissionId(request.getCarTransmissionId());
        mq.setChildrenSitNumber(request.getChildrenSitNumber());
        mq.setInsurance(request.isInsurance());
        mq.setTraveledDistance(request.getTraveledDistance());
        mq.setTraveledDistanceConstraint(request.getTraveledDistanceConstraint());
        mq.setDeleted(request.isDeleted());
        mq.setCarModelId(request.getCarModelId());
        mq.setOwner(request.getToken());

        adProducer.produceCar(mq);

        SoapResponse response = new SoapResponse();
        response.setAgId(ag.getAgentId());
        if(car==null) {
            Car car1 = new Car();
            car1.setAgent(ag);
            car1.setKeyAG(request.getId());
            List<Car> sort = carRepository.findByAgentAgentIdOrderByKeyMSDesc(ag.getAgentId());
            if(sort.isEmpty()) {
                car1.setKeyMS(1l);
            } else {
                Long key = sort.get(0).getKeyMS();
                car1.setKeyMS(++key);
            }

            response.setStatus("CREATED");
        } else {
            response.setStatus("UPDATED");
        }
        return response;


    }

}
