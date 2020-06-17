package rent.app.service;

import org.springframework.stereotype.Service;

import rent.app.dto.AdCreateDTO;
import rent.app.dto.AdDetailDTO;

@Service

public interface AdvertService {

	void createAd(AdCreateDTO newAd) throws Exception;
	AdDetailDTO findAdWithId(Long id) throws Exception;
	

}