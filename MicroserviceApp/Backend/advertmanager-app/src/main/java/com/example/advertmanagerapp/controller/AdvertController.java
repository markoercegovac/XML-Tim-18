package com.example.advertmanagerapp.controller;

import com.example.advertmanagerapp.dto.AdvertDto;
import lombok.RequiredArgsConstructor;
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


    @GetMapping ("/{advert_id}?details=more")
    public ResponseEntity<AdvertDto> getAdvertInfo(@PathVariable(value="advert_id") Long advert_id ){

        return new ResponseEntity<AdvertDto>(HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity createAdvert (@RequestBody AdvertDto advertDto){
        //upisuje u bazu
        return new ResponseEntity(HttpStatus.OK);
    }


    @PutMapping ("/update")
    public ResponseEntity updateAdvert (@RequestBody AdvertDto advertDto){
        return new ResponseEntity(HttpStatus.OK);
    }


    @DeleteMapping ("/{advert_id}")
    public ResponseEntity deleteAdvert (@PathVariable (value="advert_id") Long advert_id){
        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping("/number")
    public ResponseEntity<Integer> getAdvertNumber (){

        return new ResponseEntity<Integer>(HttpStatus.OK);
    }


    @GetMapping("/{user_id}")
    public ResponseEntity<List<AdvertDto>> getAllAdverts (@PathVariable(value="user_id") Long user_id) {

        return new ResponseEntity<List<AdvertDto>>(HttpStatus.OK);
    }

    @PostMapping("/continue/{advert_id}")
    public ResponseEntity continueAdvertTime (@RequestBody Date date,@PathVariable(value="advert_id") Long advert_id ) {

        return new ResponseEntity(HttpStatus.OK);
    }

   

}
