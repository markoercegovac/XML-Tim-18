package rent.app.controller.ws.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import rent.app.controller.ws.generate.PriceRequest;
import rent.app.controller.ws.generate.SoapResponse;

import javax.xml.bind.JAXBElement;

public class PriceClient extends WebServiceGatewaySupport {

    public SoapResponse handlePrice(PriceRequest request){
        try{

            JAXBElement<SoapResponse> jax = (JAXBElement<SoapResponse>) getWebServiceTemplate()
                    .marshalSendAndReceive(request);

            SoapResponse c = jax.getValue();

            return c;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
