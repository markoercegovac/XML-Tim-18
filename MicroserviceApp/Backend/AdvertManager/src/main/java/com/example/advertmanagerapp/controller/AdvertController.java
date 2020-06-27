package com.example.advertmanagerapp.controller;

import com.example.advertmanagerapp.dto.AdvertDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/advert-manager/advert")
@RestController
@CrossOrigin
public class AdvertController {

    private static final Logger logger = LoggerFactory.getLogger("DebugLogger");
    String className = " [" + AdvertController.class.getName() +"] ";

    @GetMapping ("/{advert_id}")
    public ResponseEntity<AdvertDto> getAdvertInfo(
            @PathVariable(value="advert_id") Long advert_id,
            @RequestParam(value = "details", required = false) String details ){
        logger.debug(className + "Info oglasa sa id: "+ advert_id);
        return new ResponseEntity<AdvertDto>(HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity createAdvert (@RequestBody AdvertDto advertDto){
        //upisuje u bazu
        logger.debug(className + "Kreiranje oglasa sa id: "+ advertDto.getId());
        return new ResponseEntity(HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity updateAdvert (@RequestBody AdvertDto advertDto){
        logger.debug(className + "Izmena oglasa sa id: "+ advertDto.getId());
        return new ResponseEntity(HttpStatus.OK);
    }


    @DeleteMapping ("/{advert_id}")
    public ResponseEntity deleteAdvert (@PathVariable (value="advert_id") Long advert_id){
        logger.debug(className + "Brisanje oglasa sa id: "+ advert_id);
        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping("/number")
    public ResponseEntity<Integer> getAdvertNumber (){
        logger.debug(className + "Preuzimanje broja ");
        return new ResponseEntity<Integer>(HttpStatus.OK);
    }


    @GetMapping("/{user_id}")
    public ResponseEntity<List<AdvertDto>> getAllAdverts (@PathVariable(value="user_id") Long user_id) {
        logger.debug(className + "Vraca sve oglase sa id: "+ user_id);
        return new ResponseEntity<List<AdvertDto>>(HttpStatus.OK);
    }

    @PostMapping("/continue/{advert_id}")
    public ResponseEntity continueAdvertTime (@RequestBody Date date,@PathVariable(value="advert_id") Long advert_id ) {
        logger.debug(className + " Continue Advert Time");
        return new ResponseEntity(HttpStatus.OK);
    }

   

}
