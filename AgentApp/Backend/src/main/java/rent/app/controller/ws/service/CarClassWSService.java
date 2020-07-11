package rent.app.controller.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import rent.app.controller.ws.WsNameSpace;
import rent.app.controller.ws.generate.CarClassRequest;
import rent.app.controller.ws.generate.SoapResponse;
import rent.app.model.CarClass;
import rent.app.repository.CarClassRepository;

@Endpoint
public class CarClassWSService {

    @Autowired
    private CarClassRepository carClassRepository;

    @PayloadRoot(namespace = WsNameSpace.namespace, localPart = "carClassRequest")
    @ResponsePayload
    public SoapResponse handleCarClass(@RequestPayload CarClassRequest request){
        CarClass carClass=new CarClass();
        carClass.setId(request.getId()==0?null:request.getId());
        carClass.setRemoved(request.isDeleted());
        carClass.setClassName(request.getName());
        System.out.println("WS RECEIVED CAR CLASS "+request);
        CarClass saved=carClassRepository.save(carClass);
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
