package rent.app.service;

import rent.app.dto.AdvertDto;

import java.io.IOException;

public interface AdvertService {
    void saveAdvert(AdvertDto advertDto) throws IOException;
}
