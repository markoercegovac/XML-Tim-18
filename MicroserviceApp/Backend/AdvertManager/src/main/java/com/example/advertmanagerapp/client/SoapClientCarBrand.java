//package com.example.advertmanagerapp.client;
//
//
//import com.example.advertmanagerapp.generate.CreateCarBrandRequest;
//import com.example.advertmanagerapp.generate.CreateCarBrandResponse;
//import com.example.advertmanagerapp.model.CarBrand;
//import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
//
//import javax.xml.bind.JAXBElement;
//
//public class SoapClientCarBrand extends WebServiceGatewaySupport {
//
//    public CreateCarBrandResponse createCarBrand(CarBrand newBrand) {
//        CreateCarBrandRequest request = new CreateCarBrandRequest();
//        request.setIsRemoved(newBrand.isRemoved());
//        request.setName(newBrand.getName());
//
//        try{
//            JAXBElement<CreateCarBrandResponse> jax = (JAXBElement<CreateCarBrandResponse>) getWebServiceTemplate()
//                    .marshalSendAndReceive(request);
//            CreateCarBrandResponse c = jax.getValue();
//
//            return c;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//
//    }
//}
