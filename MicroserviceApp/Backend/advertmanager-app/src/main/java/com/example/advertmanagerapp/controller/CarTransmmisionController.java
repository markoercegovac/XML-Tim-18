package com.example.advertmanagerapp.controller;


import com.example.advertmanagerapp.dto.CarTransmissionTypeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/car-transmission")
@RestController
@CrossOrigin
public class CarTransmmisionController {

    @GetMapping("/all")
    public ResponseEntity<List<CarTransmissionTypeDto>> getCarTransmision(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createCarTransmision(@RequestBody CarTransmissionTypeDto carTransmisionDto){
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CarTransmissionTypeDto> updateCarTransmision(@RequestBody CarTransmissionTypeDto carTransmisionDto){
        return new ResponseEntity<CarTransmissionTypeDto>(HttpStatus.OK);
    }

    @DeleteMapping("/{transmision_id}")
    public ResponseEntity<CarTransmissionTypeDto> deleteCarTransmision(@PathVariable(value = "id") Long id){
        return new ResponseEntity<CarTransmissionTypeDto>(HttpStatus.OK);
    }
}
