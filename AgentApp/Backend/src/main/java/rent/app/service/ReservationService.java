package rent.app.service;

import rent.app.dto.DTOEntity;
import rent.app.dto.ReservationDto;
import rent.app.model.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation reservation(ReservationDto reservationDto);
    List<DTOEntity> allReservationForAdvert(Long advertId);
}
