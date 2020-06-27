package com.example.advertmanagerapp.controller;


import com.example.advertmanagerapp.dto.CarTransmissionTypeDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/advert-manager/car-transmission")
@RestController
@CrossOrigin
public class CarTransmmisionController {

    private static final Logger logger = LoggerFactory.getLogger("DebugLogger");
    String className = " [" + CarTransmmisionController.class.getName() +"] ";

    @GetMapping("/all")
    public ResponseEntity<List<CarTransmissionTypeDto>> getCarTransmision(){
        logger.debug(className + "Preuzmi sve menjace");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createCarTransmision(@RequestBody CarTransmissionTypeDto carTransmisionDto){
        logger.debug(className + "Kreiraj menjac sa id: "+ carTransmisionDto.getId());
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CarTransmissionTypeDto> updateCarTransmision(@RequestBody CarTransmissionTypeDto carTransmisionDto){
        logger.debug(className + "Izmeni menjac sa id: "+ carTransmisionDto.getId());
        return new ResponseEntity<CarTransmissionTypeDto>(HttpStatus.OK);
    }

    @DeleteMapping("/{transmision_id}")
    public ResponseEntity<CarTransmissionTypeDto> deleteCarTransmision(@PathVariable(value = "id") Long id){
        logger.debug(className + "Obrisi menjac sa id: "+ id);
        return new ResponseEntity<CarTransmissionTypeDto>(HttpStatus.OK);
    }
}
