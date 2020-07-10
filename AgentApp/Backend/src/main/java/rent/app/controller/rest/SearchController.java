package rent.app.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rent.app.dto.AdvertSearchDto;
import rent.app.service.SearchService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@CrossOrigin
public class SearchController {

    private final SearchService searchService;

    Date datumPoc = new Date();
    Date datumKraj = new Date();

    @PostMapping("/search/{city}/{startOfAdvert}/{endOfAdvert}")
    public ResponseEntity<Set<AdvertSearchDto>> getAdverts(@PathVariable("city") String city, @PathVariable("startOfAdvert") String startOfAdvert,
                                                           @PathVariable("endOfAdvert") String endOfAdvert){


        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try{

            datumPoc = formatter.parse(startOfAdvert);
            datumKraj = formatter.parse(endOfAdvert);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }

        Set<AdvertSearchDto> list = this.searchService.findFreeAdverts(city,datumPoc,datumKraj);

        for (AdvertSearchDto a : list) {
            System.out.println(a.getCity() + a.getAdvertCopyId());
        }

        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("/svi")
    public ResponseEntity<Set<AdvertSearchDto>> svi(){

        Set<AdvertSearchDto> lista = searchService.findAllAdverts();
        for (AdvertSearchDto a : lista) {
            System.out.println(a.getCity() + a.getAdvertCopyId() + a.getCarClass() + a.getCarFuelType() + a.getCarMark() + a.getCarTransmissionType() + a.getModelMark() + a.getPrice());
        }

        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
}
