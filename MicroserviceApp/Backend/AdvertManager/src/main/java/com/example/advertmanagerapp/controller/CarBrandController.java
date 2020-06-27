package com.example.advertmanagerapp.controller;


import com.example.advertmanagerapp.dto.CarBrandDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("advert-manager/car-brand")
@RestController
@CrossOrigin
public class CarBrandController {

    private static final Logger logger = LoggerFactory.getLogger("DebugLogger");
    String className = " [" + CarBrandController.class.getName() +"] ";

    @GetMapping("/all")
    public ResponseEntity<List<CarBrandDto>> getCarBrand(){
        logger.debug(className + "Vrati sve brendove: ");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createCarBrand(@RequestBody CarBrandDto carBrandDto){
        logger.debug(className + "Kreiraj brend sa imenom: "+ carBrandDto.getName());
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CarBrandDto> updateCarBrand(@RequestBody CarBrandDto carBrandDto){
        logger.debug(className + "Izmeni brend sa imenom: "+ carBrandDto.getName());
        return new ResponseEntity<CarBrandDto>(HttpStatus.OK);
    }

    @DeleteMapping("/{brand_id}")
    public ResponseEntity<CarBrandDto> deleteCarBrand(@PathVariable(value = "id") Long id){
        logger.debug(className + "Obrisi brend sa id: "+ id);
        return new ResponseEntity<CarBrandDto>(HttpStatus.OK);
    }
}
