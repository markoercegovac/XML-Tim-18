package com.example.advertmanagerapp.controller;


import com.example.advertmanagerapp.dto.CarModelDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/advert-manager/car-model")
@RestController
@CrossOrigin
public class CarModelController {

    private static final Logger logger = LoggerFactory.getLogger("DebugLogger");
    String className = " [" + CarModelController.class.getName() +"] ";

    @GetMapping("/all")
    public ResponseEntity<List<CarModelDto>> getCarModel(){
        logger.debug(className + "Preuzmi sve modele");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createCarModel(@RequestBody CarModelDto carModelDto){
        logger.debug(className + "Kreiraj model sa imenom: "+ carModelDto.getModelName());
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CarModelDto> updateCarModel(@RequestBody CarModelDto carModelDto){
        logger.debug(className + "Izmeni model sa imenom: "+ carModelDto.getModelName());
        return new ResponseEntity<CarModelDto>(HttpStatus.OK);
    }

    @DeleteMapping("/{model_id}")
    public ResponseEntity<CarModelDto> deleteCarModel(@PathVariable(value = "id") Long id){
        logger.debug(className + "Obrisi model sa id: "+ id);
        return new ResponseEntity<CarModelDto>(HttpStatus.OK);
    }
}

