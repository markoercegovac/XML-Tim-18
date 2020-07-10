package rent.app.service.impl;

import lombok.Data;
import org.springframework.stereotype.Service;
import rent.app.dto.AdvertSearchDto;
import rent.app.model.*;
import rent.app.repository.AdvertRepository;
import rent.app.repository.CarRepository;
import rent.app.repository.PriceRepository;
import rent.app.repository.ReservationRepository;
import rent.app.service.SearchService;

import java.util.*;

@Data
@Service
public class SearchServiceImpl implements SearchService {

    private final AdvertRepository advertRepository;
    private final ReservationRepository reservationRepository;
    private final CarRepository carRepository;
    private final PriceRepository priceRepository;

    @Override
    public Set<AdvertSearchDto> findFreeAdverts(String city, Date start, Date end) {

        Set<AdvertSearchDto> advertSearch = this.findAllAdverts();

        Set<AdvertSearchDto> konacna = new HashSet<>();
        Set<AdvertSearchDto> listaSlobodnihDatuma = new HashSet<>();
        boolean prekinuto = false;

        for (AdvertSearchDto aa: advertSearch) {
            label1:
            for (Reservation cc : aa.getCarReservedDate()) {
                if(cc.getTakeDate().compareTo(start) > 0 && cc.getTakeDate().compareTo(end) < 0 ||
                        cc.getLeaveDate().compareTo(start) > 0 && cc.getLeaveDate().compareTo(end) < 0  ){
                    prekinuto=true;
                    break label1;
                }
            }
            if(!prekinuto){
                listaSlobodnihDatuma.add(aa);
            }
            prekinuto=false;
        }

        for (AdvertSearchDto a: listaSlobodnihDatuma) {
            if(a.getCity().equals(city)){
                konacna.add(a);
            }
        }

        return konacna;
    }

    @Override
    public Set<AdvertSearchDto> findAllAdverts() {
        List<Advert> listaOglasa = this.advertRepository.findAll();

        Set<AdvertSearchDto> konacna = new HashSet<>();

        for (Advert a : listaOglasa) {
            AdvertSearchDto model = new AdvertSearchDto();
            Car auto = new Car();
            Price cena = new Price();
            auto = this.carRepository.findAllById(a.getCar().getId());
            cena = this.priceRepository.findAllById(a.getPrice().getId());
            model.setModelMark(auto.getCarModel().getModelName());
            model.setCarTransmissionType(auto.getCarTransmissionType().getTransmissionType());
            model.setCarFuelType(auto.getCarFuelType().getFuelType());
            model.setCarClass(auto.getCarClass().getClassName());
            model.setCarMark(auto.getCarModel().getModelName());
            model.setPrice(cena.getPricePerDay());
            model.setCity(a.getCity());
            model.setCarReservedDate(a.getReservations());
            konacna.add(model);

        }

        return konacna;
    }
}
