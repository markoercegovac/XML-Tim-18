package rent.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rent.app.dto.DTOEntity;
import rent.app.dto.DtoUtils;
import rent.app.dto.PriceDto;
import rent.app.model.Client;
import rent.app.model.Price;
import rent.app.repository.ClientRepository;
import rent.app.repository.PriceRepository;
import rent.app.service.PriceService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {
    private final ClientRepository clientRepository;
    private final PriceRepository priceRepository;
    private final DtoUtils dtoUtils;

    @Override
    public Price createPrice(PriceDto priceDto,String ownerEmail) {
        Client owner = clientRepository.findById(ownerEmail).get();
        Price price=(Price) dtoUtils.convertToEntity(new Price(),priceDto);
        price.setId(null);
        Price retPrice=priceRepository.save(price);
        owner.getPriceList().add(price);
        clientRepository.save(owner);
        return retPrice;
    }

    @Override
    public List<DTOEntity> allPrices(String ownerEmail) {
        return clientRepository.findById(ownerEmail).get().getPriceList().stream().map(p->dtoUtils.convertToDto(p,new PriceDto())).collect(Collectors.toList());
    }
}
