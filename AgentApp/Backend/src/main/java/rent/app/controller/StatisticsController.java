package rent.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import rent.app.dto.StatisticsDto;
import rent.app.service.StatisticsService;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@CrossOrigin
public class StatisticsController {

    private final StatisticsService statisticsService;

    @GetMapping("/statistics")
    public List<StatisticsDto> getStatistics(){

        List<StatisticsDto> lista = statisticsService.getStatistic();

        for (StatisticsDto s: lista) {
            System.out.println(s.getNameCar() + s.getMark() + s.getTraveledKm());

        }

        return lista;
    }
}
