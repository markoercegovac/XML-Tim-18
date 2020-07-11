package rent.app.service;

import rent.app.dto.DTOEntity;
import rent.app.dto.PriceDto;
import rent.app.model.Price;

import java.util.List;

public interface PriceService {
    Price createPrice(PriceDto priceDto, String ownerEmail);
    List<DTOEntity> allPrices(String ownerEmail);
}
