package rent.app.controller.ws;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import rent.app.controller.ws.dto.CreateCarBrandRequest;
import rent.app.controller.ws.dto.CreateCarBrandResponse;
import rent.app.model.CarBrand;
import rent.app.repository.CarBrandRepository;

@Endpoint
public class SoapCarBrand {

    @Autowired
    private CarBrandRepository repo;

    @PayloadRoot(namespace = WSEndpoint.NAMESPACE_URI, localPart = "createCarBrandRequest")
    @ResponsePayload
    CreateCarBrandResponse createCarBrand(@RequestPayload CreateCarBrandRequest request) {
        CreateCarBrandResponse response = new CreateCarBrandResponse();

        try {
            //POZIVA SERVIS

            CarBrand brand = new CarBrand();
            brand.setName(request.getName());
            brand.setRemoved(request.isRemoved());

            repo.save(brand);

            response.setStatus("CREATED");
        } catch(Exception e) {
            e.printStackTrace();
            response.setStatus("FAILED");
        }

        return response;
    }
}
