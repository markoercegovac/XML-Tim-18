package rent.app.controller.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import rent.app.controller.ws.WsNameSpace;
import rent.app.controller.ws.generate.AdvertRequest;
import rent.app.controller.ws.generate.CarBrandRequest;
import rent.app.controller.ws.generate.SoapResponse;
import rent.app.model.CarBrand;
import rent.app.repository.CarBrandRepository;

@Endpoint
public class CarBrandWSService {

	@Autowired
	private CarBrandRepository carBrandRepository;

	@PayloadRoot(namespace = WsNameSpace.namespace, localPart = "carBrandRequest") //SA MALIM POCETNIM SLOVOM
	@ResponsePayload
	public SoapResponse handleCarBrand(@RequestPayload CarBrandRequest request) {
		CarBrand brand = new CarBrand();
		brand.setId(request.getId()==0?null:request.getId());
		brand.setRemoved(request.isDeleted());
		brand.setName(request.getName());
		System.out.println("WS RECEIVED CAR BRAND "+request);
		CarBrand saved = carBrandRepository.save(brand);

		SoapResponse response = new SoapResponse();
		if(request.getId()==0) {
			response.setAgId(saved.getId());
			response.setStatus("CREATED");
		} else {
			response.setAgId(saved.getId());
			response.setStatus("UPDATED");
		}

		AdvertRequest a = new AdvertRequest();


		return response;
	}
}
