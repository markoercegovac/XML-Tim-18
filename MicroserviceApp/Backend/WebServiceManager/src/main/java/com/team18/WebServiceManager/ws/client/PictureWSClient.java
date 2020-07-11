package com.team18.WebServiceManager.ws.client;

import com.team18.WebServiceManager.ws.endpoint.dto.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.xml.bind.JAXBElement;

public class PictureWSClient extends WebServiceGatewaySupport {

    public SoapResponse handlePicture(PictureRequest request) {
        try {

            JAXBElement<SoapResponse> jax = (JAXBElement<SoapResponse>) getWebServiceTemplate()
                    .marshalSendAndReceive(request); //za ovo mapiranje koristi se ObjectFactory

            SoapResponse response = jax.getValue();
            return response;
        } catch (Exception e) {
            return null;
        }
    }
}
