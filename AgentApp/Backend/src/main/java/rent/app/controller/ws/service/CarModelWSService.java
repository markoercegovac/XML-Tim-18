package rent.app.controller.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import rent.app.controller.ws.WsNameSpace;
import rent.app.controller.ws.generate.CarModelRequest;
import rent.app.controller.ws.generate.SoapResponse;
import rent.app.model.CarModel;
import rent.app.repository.CarModelRepository;

@Endpoint
public class CarModelWSService {
    @Autowired
    private CarModelRepository carModelRepository;

    @PayloadRoot(namespace = WsNameSpace.namespace,localPart = "carModelRequest")
    @ResponsePayload
    public SoapResponse handleCarModel(@RequestPayload CarModelRequest request){
        CarModel carModel=new CarModel();
        carModel.setId(request.getId()==0?null:request.getId());
        carModel.setModelName(request.getName());
        carModel.setRemoved(request.isDeleted());
        System.out.println("WS RECEIVED CAR MODEL "+request);
        CarModel saved=carModelRepository.save(carModel);
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
