package rent.app.service;

import rent.app.dto.AdvertDto;
import rent.app.dto.AdvertMiniDto;

import java.io.IOException;
import java.util.List;

public interface AdvertService {
    void saveAdvert(AdvertDto advertDto) throws IOException;
    List<AdvertMiniDto> getAllAdverts() throws IOException;

}
