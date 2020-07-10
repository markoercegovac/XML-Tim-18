package rent.app.service.impl;

import lombok.Data;
import org.springframework.stereotype.Service;
import rent.app.dto.StatisticsDto;
import rent.app.model.Advert;
import rent.app.model.Car;
import rent.app.model.DriveReport;
import rent.app.model.Grade;
import rent.app.repository.AdvertRepository;
import rent.app.repository.CarRepository;
import rent.app.repository.GradeRepository;
import rent.app.service.StatisticsService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Service
public class StatisticsServiceImpl implements StatisticsService {

    private final AdvertRepository advertRepository;
    private final GradeRepository gradeRepository;
    private final CarRepository carRepository;


    @Override
    public List<StatisticsDto> getStatistic() {

        List<Advert> sviOglasi = this.advertRepository.findAll();
        List<StatisticsDto> statistika = new ArrayList<>();
        List<Grade> sveOceneOglasa = new ArrayList<>();


        for (Advert a: sviOglasi) {
            int br = 0;
            float sumaOcena = 0;
            float sumaKm = 0;
            StatisticsDto objekat = new StatisticsDto();
            objekat.setNameCar(a.getCar().getCarBrand().getName());

            sveOceneOglasa = this.gradeRepository.findAllByAdvertId(a.getId());
            for (Grade g: sveOceneOglasa) {
                br+=g.getGrade();
            }
            sumaOcena += br/sveOceneOglasa.size();
            objekat.setMark(sumaOcena);

            objekat.setComment(a.getComments().size());

            Car car = this.carRepository.findAllById(a.getCar().getId());
            for (DriveReport d: car.getReports()) {
                sumaKm+=d.getTraveledDistance();
            }
            objekat.setTraveledKm(sumaKm);

            statistika.add(objekat);
        }

        return statistika;
    }
}
