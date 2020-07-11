package rent.app.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import rent.app.controller.ws.client.CaptureClient;
import rent.app.controller.ws.generate.CaptureRequest;
import rent.app.controller.ws.generate.ReservationRequest;
import rent.app.controller.ws.generate.SoapResponse;
import rent.app.model.Reservation;
import rent.app.repository.ReservationRepository;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

@Component
@Aspect
@RequiredArgsConstructor
public class CaptureAspect {
    private final CaptureClient captureClient;
    private final ReservationRepository reservationRepository;

    @AfterReturning(pointcut = "execution(* rent.app.service.impl .ReservationServiceImpl.reservation(..))", returning = "reservation")
    public void afterSavedReservation(JoinPoint joinPoint, Reservation reservation) throws DatatypeConfigurationException {
        CaptureRequest request=new CaptureRequest();
        request.setId(reservation.getId());
        String end=reservation.getLeaveDate().toString();
        request.setEnd(DatatypeFactory.newInstance().newXMLGregorianCalendar(end));
        String start=reservation.getTakeDate().toString();
        request.setStart(DatatypeFactory.newInstance().newXMLGregorianCalendar(start));
        request.setToken("firm@com");

        SoapResponse response=captureClient.handleCapture(request);
        System.out.println("STATUS: "+ response.getStatus());

    }

}
