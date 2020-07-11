package rent.app.controller.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import rent.app.controller.ws.WsNameSpace;
import rent.app.controller.ws.generate.PictureRequest;
import rent.app.controller.ws.generate.PriceRequest;
import rent.app.controller.ws.generate.SoapResponse;
import rent.app.model.Picture;
import rent.app.model.Price;
import rent.app.repository.PriceRepository;

@Endpoint
public class PriceWSService {
    @Autowired
    private PriceRepository priceRepository;

    @PayloadRoot(namespace = WsNameSpace.namespace, localPart = "priceRequest")
    @ResponsePayload
    public SoapResponse handlePicture(@RequestPayload PriceRequest request){
        Price price=new Price();
        price.setId(request.getId()==0?null:request.getId());
        price.setDiscount(request.getDiscount());
        price.setDistanceOverflowPrice(request.getDistanceOverflowPrice());
        price.setInsurancePrice(request.getInsurancePrice());
        price.setPricePerDay(request.getPricePerDay());
        price.setName(request.getName());
        price.setRemoved(request.isDeleted());
        System.out.println("WS RECEIVED PRICE "+request);
        request.setToken("firm@com");
        Price saved=priceRepository.save(price);
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
