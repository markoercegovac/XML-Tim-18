package rent.app.service;

import rent.app.dto.DTOEntity;
import rent.app.dto.PriceDto;

import java.util.List;

public interface PriceService {
    void createPrice(PriceDto priceDto,String ownerEmail);
    List<DTOEntity> allPrices(String ownerEmail);
}
