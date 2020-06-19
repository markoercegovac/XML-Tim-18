package rent.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rent.app.dto.AdvertDto;
import rent.app.dto.DtoUtils;
import rent.app.model.Advert;
import rent.app.model.Picture;
import rent.app.repository.CarRepository;
import rent.app.repository.PictureRepository;
import rent.app.repository.PriceRepository;
import rent.app.service.AdvertService;
import rent.app.service.PictureService;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AdvertServiceImpl implements AdvertService {

    private final PictureService pictureService;
    private final PictureRepository pictureRepository;
    private final PriceRepository priceRepository;
    private final CarRepository carRepository;
    private final DtoUtils dtoUtils;

    @Override
    public void saveAdvert(AdvertDto advertDto) {
        Advert advert= (Advert) dtoUtils.convertToEntity(new Advert(),advertDto);
//        Set<Picture> gallery=advertDto.getPictureSet().stream()

    }
}
