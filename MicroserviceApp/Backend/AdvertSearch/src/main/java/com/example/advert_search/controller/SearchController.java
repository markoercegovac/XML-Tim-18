package com.example.advert_search.controller;

import com.example.advert_search.dto.AdvertCopyDto;
import com.example.advert_search.dto.CarReservedDateDto;
import com.example.advert_search.repository.CarReservedDateRepository;
import com.example.advert_search.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.hibernate.dialect.identity.HSQLIdentityColumnSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RequestMapping("/search-manager")
@RestController
@CrossOrigin
public class SearchController {

    private final SearchService searchService;
    private final CarReservedDateRepository carReservedDateRepository;

    Date datumPoc = new Date();
    Date datumKraj = new Date();

    //pozovem jednom da mi se formiraju u bazi objekti
   @GetMapping("/objects")
   public ResponseEntity<?> getObjects(){

       searchService.makeObjects();

       return new ResponseEntity<>(HttpStatus.OK);
   }

    @PostMapping("/search/{city}/{startOfAdvert}/{endOfAdvert}")
    public ResponseEntity<?> getAdverts(@PathVariable("city") String city, @PathVariable("startOfAdvert") String startOfAdvert,
                                        @PathVariable("endOfAdvert") String endOfAdvert){


        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try{

            datumPoc = formatter.parse(startOfAdvert);
            datumKraj = formatter.parse(endOfAdvert);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }


        if (startOfAdvert.equals("undefined") || startOfAdvert.equals("")) {

            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }
        if (endOfAdvert.equals("undefined") || endOfAdvert.equals("")) {

            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }
        if (city.equals("undefined") || city.equals("")) {

            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }

       Set<AdvertCopyDto> list = this.searchService.findFreeAdverts(datumPoc,datumKraj);

        for (AdvertCopyDto a : list) {
            System.out.println(a.getCity() + a.getAdvertCopyId());
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
