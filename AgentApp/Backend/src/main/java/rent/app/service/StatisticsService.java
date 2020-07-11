package rent.app.service;

import org.springframework.stereotype.Service;
import rent.app.dto.StatisticsDto;

import java.util.List;
import java.util.Set;

@Service
public interface StatisticsService {

    List<StatisticsDto> getStatistic(String ownerEmail);
}
