package rent.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rent.app.dto.*;
import rent.app.model.*;
import rent.app.repository.*;
import rent.app.service.AdvertService;
import rent.app.service.GradeService;
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
    private final ClientRepository clientRepository;
    private final PriceRepository priceRepository;
    private final CarRepository carRepository;
    private final AdvertRepository advertRepository;
    private final GradeService gradeService;
    private final DtoUtils dtoUtils;

    @Override
    public void saveAdvert(AdvertDto advertDto,String ownerEmail) throws IOException {
        Client owner=clientRepository.findByUsername(ownerEmail);
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
        advert.setCity(owner.getCity());
        Advert advert1=advertRepository.save(advert);
        advert.setOwner(ownerEmail);
        owner.getAdvertList().add(advert);
        clientRepository.save(owner);

    }

    @Override
    public List<AdvertMiniDto> getAllAdverts() throws IOException {
        List<Advert> adverts=advertRepository.findAll();
        List<AdvertMiniDto> advertMiniDtos=new ArrayList<>();

        for(Advert a: adverts){
            AdvertMiniDto advertMiniDto=new AdvertMiniDto();
            advertMiniDto.setGrade(gradeService.getGradeForAd(a.getId()));
            advertMiniDto.setAdvertId(a.getId());
            advertMiniDto.setCarBrand(a.getCar().getCarBrand().getName());
            advertMiniDto.setCarModel(a.getCar().getCarModel().getModelName());
            advertMiniDto.setDistanceUnit(a.getCar().getTravelDistanceConstraint().toString());
            advertMiniDto.setPrice(a.getPrice().getPricePerDay());
            advertMiniDto.setProfilePicture(pictureService.getProfilePicture(a.getProfilePicture()));
            advertMiniDtos.add(advertMiniDto);
        }


        return advertMiniDtos;
    }

    @Override
    public AdvertFullDto getAdvert(Long id) throws IOException {
        Advert advert=advertRepository.findById(id).get();
        AdvertFullDto advertFullDto=new AdvertFullDto();
        advertFullDto.setAdvertId(advert.getId());
        advertFullDto.setCarBrand(advert.getCar().getCarBrand().getName());
        advertFullDto.setCarModel(advert.getCar().getCarModel().getModelName());
        advertFullDto.setPrice(advert.getPrice().getPricePerDay());
        advertFullDto.setDescription(advert.getDescription());

        List<Client> clients=clientRepository.findAll();
        advertFullDto.setOwnerEmail(advert.getOwner());


        advertFullDto.setProfileImage(pictureService.getProfilePicture(advert.getProfilePicture()));
        List<String> pictures=new ArrayList<>();
        for(Picture p : advert.getPictureSet()){
            pictures.add(pictureService.getProfilePicture(p));
        }
        advertFullDto.setGalleryImages(pictures);
        return advertFullDto;
    }

    @Override
    public List<DTOEntity> getAllMyAdverts(String clientEmail) throws IOException {
        Client client=clientRepository.findById(clientEmail).get();
        List<DTOEntity> advertMiniDtos=new ArrayList<>();
        for(Advert a: client.getAdvertList()){
            AdvertMiniDto advertMiniDto=new AdvertMiniDto();
            advertMiniDto.setGrade(gradeService.getGradeForAd(a.getId()));
            advertMiniDto.setAdvertId(a.getId());
            advertMiniDto.setCarBrand(a.getCar().getCarBrand().getName());
            advertMiniDto.setCarModel(a.getCar().getCarModel().getModelName());
            advertMiniDto.setDistanceUnit(a.getCar().getTravelDistanceConstraint().toString());
            //aadvertMiniDto.setPrice(a.getPrice().getPricePerDay());
            advertMiniDto.setProfilePicture(pictureService.getProfilePicture(a.getProfilePicture()));
            advertMiniDtos.add(advertMiniDto);
        }

        return advertMiniDtos;
    }


}
