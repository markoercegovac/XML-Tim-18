package com.team18.WebServiceManager.ws.client;

import com.team18.WebServiceManager.ws.dto.CarBrandRequest;
import com.team18.WebServiceManager.ws.dto.SoapResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.xml.bind.JAXBElement;

public class CarBrandWSClient extends WebServiceGatewaySupport {

	public SoapResponse handleCarBrand(CarBrandRequest request) {
		try {

			JAXBElement<SoapResponse> jax = (JAXBElement<SoapResponse>) getWebServiceTemplate()
					.marshalSendAndReceive(request);

			SoapResponse response = jax.getValue();
			return response;
		} catch (Exception e) {
			return null;
		}
	}
}