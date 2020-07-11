package rent.app.controller.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import rent.app.controller.ws.WsNameSpace;
import rent.app.controller.ws.generate.CaptureRequest;
import rent.app.controller.ws.generate.ReservationRequest;
import rent.app.controller.ws.generate.SoapResponse;
import rent.app.model.Reservation;
import rent.app.repository.ReservationRepository;

import java.util.Date;


@Endpoint
public class CaptureWSService {

    @Autowired
    private ReservationRepository reservationRepository;

    @PayloadRoot(namespace = WsNameSpace.namespace, localPart = "captureRequest")
    @ResponsePayload
    public SoapResponse handleCapture(@RequestPayload CaptureRequest request){
        Reservation capture=new Reservation();
        capture.setId(request.getId()==0?null:request.getId());
        Date start = request.getStart().toGregorianCalendar().getTime();
        Date end = request.getEnd().toGregorianCalendar().getTime();
        capture.setLeaveDate(end);
        capture.setTakeDate(start);
        request.setToken("firm@com");
        System.out.println("WS RECEIVED RESERVATION "+request);
        Reservation saved=reservationRepository.save(capture);
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
