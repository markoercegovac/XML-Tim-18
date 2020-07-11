package com.team18.WebServiceManager.ws.client;

import com.team18.WebServiceManager.ws.endpoint.dto.CommentRequest;
import com.team18.WebServiceManager.ws.endpoint.dto.ReservationRequest;
import com.team18.WebServiceManager.ws.endpoint.dto.SoapResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.xml.bind.JAXBElement;

public class ReservationWSClinet extends WebServiceGatewaySupport {

	public SoapResponse handleReservation(ReservationRequest request) {
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
