package rent.app.controller.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import rent.app.controller.ws.WsNameSpace;
import rent.app.controller.ws.generate.CarTransmissionRequest;
import rent.app.controller.ws.generate.SoapResponse;
import rent.app.model.CarTransmissionType;
import rent.app.repository.CarTransmissionRepository;

@Endpoint
public class CarTransmissionWSService {
    @Autowired
    private CarTransmissionRepository carTransmissionRepository;

    @PayloadRoot(namespace = WsNameSpace.namespace,localPart = "carTransmissionRequest")
    @ResponsePayload
    public SoapResponse handleCarTransmission(@RequestPayload CarTransmissionRequest request){
        CarTransmissionType transmissionType=new CarTransmissionType();
        transmissionType.setId(request.getId()==0?null:request.getId());
        transmissionType.setTransmissionType(request.getName());
        transmissionType.setRemoved(request.isDeleted());
        System.out.println("WS RECEIVED CAR TRANSMISSION "+request);
        CarTransmissionType saved=carTransmissionRepository.save(transmissionType);
        request.setToken("firm@com");
        SoapResponse response = new SoapResponse();
        if(request.getId()==0) {
            response.setAgId(saved.getId());
            response.setStatus("CREATED");
        } else {
            response.setAgId(saved.getId());
            response.setStatus("UPDATED");
        }

        return response;
    }
}
