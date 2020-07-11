package rent.app.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rent.app.model.AdvertRequest;
import rent.app.model.ReservationRequest;
import rent.app.repository.AdvertRequestRepository;
import rent.app.repository.ReservationRequestRepository;
import rent.app.service.AdvertRequestService;

@Service
@AllArgsConstructor
public class AdvertRequestServiceImp  implements AdvertRequestService {

    private final AdvertRequestRepository advertRequestRepository;

    private final ReservationRequestRepository reservationRequestRepository;

    @Override
    public void saveAdvertRequest(AdvertRequest advertRequest) {
        advertRequest.setApproved(true);
        ReservationRequest reservationRequest=new ReservationRequest();
        reservationRequest.setCustomerEmail(advertRequest.getUserEmail());
        reservationRequest.setOwnerEmail("firm@com");
        reservationRequest.setAccepted(true);
        reservationRequestRepository.save(reservationRequest);
        advertRequestRepository.save(advertRequest);
    }
}
