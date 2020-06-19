package rent.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rent.app.dto.AdvertDto;
import rent.app.dto.DtoUtils;
import rent.app.dto.PictureDto;
import rent.app.model.Advert;
import rent.app.model.Picture;
import rent.app.repository.AdvertRepository;
import rent.app.repository.CarRepository;
import rent.app.repository.PictureRepository;
import rent.app.repository.PriceRepository;
import rent.app.service.AdvertService;
import rent.app.service.PictureService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AdvertServiceImpl implements AdvertService {

    private final PictureService pictureService;
    private final PictureRepository pictureRepository;
    private final PriceRepository priceRepository;
    private final CarRepository carRepository;
    private final AdvertRepository advertRepository;
    private final DtoUtils dtoUtils;

    @Override
    public void saveAdvert(AdvertDto advertDto) throws IOException {
        pictureService.saveProfilePicture(advertDto.getProfilePicture());
        advertDto.getPictureSet().forEach(p-> {
            try {
                pictureService.saveProfilePicture(p);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        Advert advert= (Advert) dtoUtils.convertToEntity(new Advert(),advertDto);

        Picture profilePicture= (Picture) dtoUtils.convertToEntity(new Picture(),advertDto.getProfilePicture());
        pictureRepository.save(profilePicture);
        advert.setProfilePicture(profilePicture);

        Advert advert1=advertRepository.save(advert);


    }
}
