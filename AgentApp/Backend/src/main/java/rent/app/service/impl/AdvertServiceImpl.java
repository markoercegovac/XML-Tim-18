package rent.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rent.app.dto.AdvertDto;
import rent.app.dto.AdvertMiniDto;
import rent.app.dto.DtoUtils;
import rent.app.model.Advert;
import rent.app.model.Car;
import rent.app.model.Picture;
import rent.app.model.Price;
import rent.app.repository.AdvertRepository;
import rent.app.repository.CarRepository;
import rent.app.repository.PictureRepository;
import rent.app.repository.PriceRepository;
import rent.app.service.AdvertService;
import rent.app.service.PictureService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


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
        Price price=priceRepository.findById(advertDto.getPriceId()).get();
        advert.setPrice(price);
        Car car=carRepository.findById(advertDto.getCarId()).get();
        advert.setCar(car);
        Picture profilePicture= (Picture) dtoUtils.convertToEntity(new Picture(),advertDto.getProfilePicture());
        pictureRepository.save(profilePicture);
        advert.setProfilePicture(profilePicture);

        Advert advert1=advertRepository.save(advert);


    }

    @Override
    public List<AdvertMiniDto> getAllAdverts() throws IOException {
        List<Advert> adverts=advertRepository.findAll();
        List<AdvertMiniDto> advertMiniDtos=new ArrayList<>();

        for(Advert a: adverts){
            AdvertMiniDto advertMiniDto=new AdvertMiniDto();
            advertMiniDto.setAdvertId(a.getId());
            advertMiniDto.setCarBrand(a.getCar().getCarBrand().getName());
            advertMiniDto.setCarModel(a.getCar().getCarModel().getModelName());
            //advertMiniDto.setDistanceUnit(a.getCar().getTravelDistanceConstraint().toString());
//            advertMiniDto.setPrice(a.getPrice().getPricePerDay());
//            advertMiniDto.setProfilePicture(pictureService.getProfilePicture(a.getProfilePicture()));
            advertMiniDtos.add(advertMiniDto);
        }


        return advertMiniDtos;
    }


}
