package com.example.advertmanagerapp.controller;


import com.example.advertmanagerapp.dto.CarFuelTypeDto;
import com.example.advertmanagerapp.model.CarFuelType;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/advert-manager/car-fuel-type")
@RestController
@CrossOrigin
public class CarFuelTypeController {

    private static final Logger logger = LoggerFactory.getLogger("DebugLogger");
    String className = " [" + CarFuelTypeController.class.getName() +"] ";

    @GetMapping("/all")
    public ResponseEntity<List<CarFuelTypeDto>> getCarFuelType(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createCarFuelType(@RequestBody CarFuelTypeDto carFuelTypeDto){
        logger.debug(className + "Kreiraj gorivo sa id: "+ carFuelTypeDto.getId());
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CarFuelTypeDto> updateCarFuelType(@RequestBody CarFuelTypeDto carFuelTypeDto){
        logger.debug(className + "Izmeni gorivo sa id: "+ carFuelTypeDto.getId());
        return new ResponseEntity<CarFuelTypeDto>(HttpStatus.OK);
    }

    @DeleteMapping("/car-fuelType/{fuelType_id}")
    public ResponseEntity<CarFuelTypeDto> deleteCarFuelType(@PathVariable(value = "id") Long id){
        logger.debug(className + "Obrisi gorivo sa id: "+ id);
        return new ResponseEntity<CarFuelTypeDto>(HttpStatus.OK);
    }

}
