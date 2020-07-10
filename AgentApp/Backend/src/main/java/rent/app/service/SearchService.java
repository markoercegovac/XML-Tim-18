package rent.app.service;

import rent.app.dto.AdvertSearchDto;

import java.util.Date;
import java.util.Set;

public interface SearchService {

    Set<AdvertSearchDto> findFreeAdverts(String city, Date start, Date end);
    Set<AdvertSearchDto> findAllAdverts();
}
