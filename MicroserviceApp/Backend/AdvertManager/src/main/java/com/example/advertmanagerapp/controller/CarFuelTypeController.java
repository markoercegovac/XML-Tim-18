package com.example.advertmanagerapp.controller;


import com.example.advertmanagerapp.dto.CarFuelTypeDto;
import com.example.advertmanagerapp.dto.mapper.DtoEntity;
import com.example.advertmanagerapp.service.CarFuelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/advert-manager/car-fuel-type")
@RestController
@CrossOrigin
public class CarFuelTypeController {

    private final CarFuelService carFuelService;

    @GetMapping("/all")
    public ResponseEntity<List<DtoEntity>> getCarFuelType(){
        return new ResponseEntity<>(carFuelService.allFuels(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createCarFuelType(@RequestBody CarFuelTypeDto carFuelTypeDto){
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CarFuelTypeDto> updateCarFuelType(@RequestBody CarFuelTypeDto carFuelTypeDto){
        return new ResponseEntity<CarFuelTypeDto>(HttpStatus.OK);
    }

    @DeleteMapping("/car-fuelType/{fuelType_id}")
    public ResponseEntity<CarFuelTypeDto> deleteCarFuelType(@PathVariable(value = "id") Long id){
        return new ResponseEntity<CarFuelTypeDto>(HttpStatus.OK);
    }

}
