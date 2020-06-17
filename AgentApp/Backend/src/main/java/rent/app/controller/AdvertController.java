package rent.app.controller;

import javax.print.attribute.standard.Media;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import rent.app.dto.AdCreateDTO;
import rent.app.dto.AdDetailDTO;
import rent.app.service.AdvertService;

@RequestMapping("/api/advert")
@RequiredArgsConstructor
@RestController
@CrossOrigin
public class AdvertController {
	
	private final AdvertService adSerivice;

	@PostMapping("")
	public ResponseEntity<String> createAd(@RequestBody AdCreateDTO newAd) {

		try {
			adSerivice.createAd(newAd);
			
			return new ResponseEntity<String>("Created", HttpStatus.CREATED);
		} catch(Exception e) {
			return new ResponseEntity<String>(e.getLocalizedMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<AdDetailDTO> getAd(@PathVariable("id") Long id) {

		try {
			System.out.println("PROFILE IMG "+id);
			AdDetailDTO foundAd = adSerivice.findAdWithId(id);
			
			return new ResponseEntity<AdDetailDTO>(foundAd, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<AdDetailDTO>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
}