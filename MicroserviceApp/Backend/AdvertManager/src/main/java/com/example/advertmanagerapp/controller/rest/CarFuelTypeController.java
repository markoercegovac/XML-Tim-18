package com.example.advertmanagerapp.controller.rest;


import com.example.advertmanagerapp.dto.CarFuelTypeDto;
import com.example.advertmanagerapp.model.CarFuelType;
import com.example.advertmanagerapp.service.CarFuelTypeService;
import com.example.advertmanagerapp.dto.mapper.DtoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/advert-manager/car-fuel-type")
@RestController
public class CarFuelTypeController {

    private final CarFuelTypeService fuelTypeService;


    @GetMapping("/all")
    public List<CarFuelType> getCarFuelType(){

     return fuelTypeService.getAllCarFuelType();
    }

    @PostMapping
    public ResponseEntity createCarFuelType(@RequestBody CarFuelType carFuelType){
        carFuelType.setId(null);
        fuelTypeService.saveFuelType(carFuelType);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateCarFuelType(@RequestBody CarFuelType carFuelType){
        fuelTypeService.saveFuelType(carFuelType);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{fuelType_id}")
    public ResponseEntity<CarFuelTypeDto> deleteCarFuelType(@PathVariable(value = "fuelType_id") Long id){
       fuelTypeService.deleteFuelTypeService(id);
        return new ResponseEntity<CarFuelTypeDto>(HttpStatus.OK);
    }
    @GetMapping("/all/v2")
    public ResponseEntity<List<DtoEntity>> getCarFuelTypeV2(){
        return new ResponseEntity<>(fuelTypeService.allFuels(),HttpStatus.OK);
    }

}
