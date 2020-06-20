package rent.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rent.app.dto.DTOEntity;
import rent.app.dto.DtoUtils;
import rent.app.dto.ReservationDto;
import rent.app.model.Advert;
import rent.app.model.Reservation;
import rent.app.repository.AdvertRepository;
import rent.app.repository.ReservationRepository;
import rent.app.service.ReservationService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final DtoUtils dtoUtils;
    private final AdvertRepository advertRepository;

    @Override
    public void reservation(ReservationDto reservationDto) {
        Advert advert=advertRepository.findById(reservationDto.getAdvertId()).orElse(null);
        Reservation reservation=(Reservation) dtoUtils.convertToEntity(new Reservation(), reservationDto);
        reservationRepository.save(reservation);
        advert.getReservations().add(reservation);
        advertRepository.save(advert);
    }

    @Override
    public List<DTOEntity> allReservationForAdvert(Long advertId) {
        return advertRepository.findById(advertId).get().getReservations().stream().map(c->dtoUtils.convertToDto(c,new ReservationDto())).collect(Collectors.toList());
    }
}
