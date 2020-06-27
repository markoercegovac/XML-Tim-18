package com.example.advertmanagerapp.controller;


import com.example.advertmanagerapp.dto.CarClassDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("advert-manager/car-class")
@RestController
@CrossOrigin
public class CarClassController {

    private static final Logger logger = LoggerFactory.getLogger("DebugLogger");
    String className = " [" + CarClassController.class.getName() +"] ";

    @GetMapping("/all")
    public ResponseEntity<List<CarClassDto>> getCarClass(){
        logger.debug(className + "Preuzmi sve klase ");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createCarClass(@RequestBody CarClassDto carClassDto){
        logger.debug(className + "Kreiraj klasu sa imenom: "+ carClassDto.getClassName());
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CarClassDto> updateCarClass(@RequestBody CarClassDto carClassDto){
        logger.debug(className + "Izmeni klasu sa imenom: "+ carClassDto.getClassName());
        return new ResponseEntity<CarClassDto>(HttpStatus.OK);
    }

    @DeleteMapping("/{class_id}")
    public ResponseEntity<CarClassDto> deleteCarClass(@PathVariable(value = "id") Long id){
        logger.debug(className + "Obrisi klasu sa id: "+ id);
        return new ResponseEntity<CarClassDto>(HttpStatus.OK);
    }

}
