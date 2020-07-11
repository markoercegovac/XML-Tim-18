package rent.app.controller.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import rent.app.controller.ws.WsNameSpace;
import rent.app.controller.ws.generate.CarFuelTypeRequest;
import rent.app.controller.ws.generate.SoapResponse;
import rent.app.model.CarFuelType;
import rent.app.repository.CarFuelRepository;

@Endpoint
public class CarFuelTypeWSService {

    @Autowired
    private CarFuelRepository carFuelRepository;

    @PayloadRoot(namespace = WsNameSpace.namespace,localPart = "carFuelTypeRequest")
    @ResponsePayload
    public SoapResponse handleCarFuelType(@RequestPayload CarFuelTypeRequest request){
        CarFuelType fuel=new CarFuelType();
        fuel.setId(request.getId()==0?null:request.getId());
        fuel.setFuelType(request.getName());
        fuel.setRemoved(request.isDeleted());
        System.out.println("WS RECEIVED CAR FUEL TYPE "+request);
        CarFuelType saved=carFuelRepository.save(fuel);
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
