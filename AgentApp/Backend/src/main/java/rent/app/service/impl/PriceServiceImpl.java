package rent.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rent.app.dto.DTOEntity;
import rent.app.dto.DtoUtils;
import rent.app.dto.PriceDto;
import rent.app.model.Price;
import rent.app.repository.PriceRepository;
import rent.app.service.PriceService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;
    private final DtoUtils dtoUtils;

    @Override
    public void createPrice(PriceDto priceDto) {
        priceRepository.save((Price) dtoUtils.convertToEntity(new Price(),priceDto));
    }

    @Override
    public List<DTOEntity> allPrices() {
        return priceRepository.findAll().stream().map(p->dtoUtils.convertToDto(p,new PriceDto())).collect(Collectors.toList());
    }
}
