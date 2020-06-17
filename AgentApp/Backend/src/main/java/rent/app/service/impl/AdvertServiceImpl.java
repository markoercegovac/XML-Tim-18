package rent.app.service.impl;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import rent.app.comon.ImageHandler;
import rent.app.dto.AdCreateDTO;
import rent.app.dto.AdDetailDTO;
import rent.app.model.Advert;
import rent.app.model.Car;
import rent.app.repository.AdvertRepsitory;
import rent.app.repository.CaRrepository;
import rent.app.service.AdvertService;

@Service
@RequiredArgsConstructor
public class AdvertServiceImpl implements AdvertService {

	//FALI I CENA
	private final AdvertRepsitory adRepository;
	private final CaRrepository carRepository;

	@Override
	public void createAd(AdCreateDTO newAd) throws Exception {
		
		Advert ad = new Advert();
		//Car car = carRepository.findById(newAd.getCarId()).orElse(null);
		// if(car == null) {
		// 	throw new NullPointerException("car is not defined");
		// }

		ad.setActive(true);
		//ad.setCar(car);
		ad.setDescription(newAd.getDescription());
		ad.setStartOfAdvert(newAd.getStartOfAdvert());
		ad.setEndOfAdvert(newAd.getEndOfAdvert());
		ad.setProfilePicture(newAd.getProfileImage().getBytes());
		adRepository.save(ad);
	}

	@Override
	public AdDetailDTO findAdWithId(Long id) throws Exception {
		
		//fali id od vozila
		Advert ad = adRepository.findById(id).orElse(null);
		AdDetailDTO adDetail = new AdDetailDTO(
			ad.getId(),
			0l,
			ad.getProfilePicture(),
			ad.getStartOfAdvert(),
			ad.getEndOfAdvert(),
			ad.getDescription());

		return adDetail;
	}
	
}