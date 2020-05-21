package com.example.advert_search.controller;

import com.example.advert_search.dto.AdvertCopyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/advert")
@RestController
@CrossOrigin
public class SearchController {

    @PostMapping("/search") //ili Get, razmisliti
    public ResponseEntity<List<AdvertCopyDto>> getUsers(@RequestBody AdvertCopyDto advertCopyDto){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //dodatna metoda za preuzimanje podataka iz AdvertManager-a mikroservisa

    @GetMapping("/car-brand/all")
    public ResponseEntity<List<CarBrandDto>> getCarBrand(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/car-brand")
    public ResponseEntity createCarBrand(){
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/car-brand")
    public ResponseEntity<CarBrandDto> updateCarBrand(@RequestBody CarBrandDto carBrandDto){
        return new ResponseEntity<CarBrandDto>(HttpStatus.OK);
    }

    @DeleteMapping("/car-brand/{brand_id}")
    public ResponseEntity<CarBrandDto> deleteCarBrand(@PathVariable(value = "id") Long id){
        return new ResponseEntity<CarBrandDto>(HttpStatus.OK);
    }


    @GetMapping("/car-model/all")
    public ResponseEntity<List<CarModelDto>> getCarModel(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/car-model")
    public ResponseEntity createCarModel(){
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/car-model")
    public ResponseEntity<CarModelDto> updateCarModel(@RequestBody CarModelDto carModelDto){
        return new ResponseEntity<CarModelDto>(HttpStatus.OK);
    }

    @DeleteMapping("/car-model/{model_id}")
    public ResponseEntity<CarModelDto> deleteCarModel(@PathVariable(value = "id") Long id){
        return new ResponseEntity<CarModelDto>(HttpStatus.OK);
    }



    @GetMapping("/car-class/all")
    public ResponseEntity<List<CarClassDto>> getCarClass(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/car-class")
    public ResponseEntity createCarClass(){
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/car-class")
    public ResponseEntity<CarClassDto> updateCarClass(@RequestBody CarClassDto carClassDto){
        return new ResponseEntity<CarClassDto>(HttpStatus.OK);
    }

    @DeleteMapping("/car-class/{class_id}")
    public ResponseEntity<CarClassDto> deleteCarClass(@PathVariable(value = "id") Long id){
        return new ResponseEntity<CarClassDto>(HttpStatus.OK);
    }

    -----
    @GetMapping("/carTransmision/all")
    public ResponseEntity<List<CarTransmisionDto>> getCarTransmision(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/car-transmision")
    public ResponseEntity createCarTransmision(){
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/car-transmision")
    public ResponseEntity<CarTransmisionDto> updateCarTransmision(@RequestBody CarTransmisionDto carTransmisionDto){
        return new ResponseEntity<CarTransmisionDto>(HttpStatus.OK);
    }

    @DeleteMapping("/car-transmison/{transmision_id}")
    public ResponseEntity<CarTransmisionDto> deleteCarTransmision(@PathVariable(value = "id") Long id){
        return new ResponseEntity<CarTransmisionDto>(HttpStatus.OK);
    }

    -------
    @GetMapping("/carFuelType/all")
    public ResponseEntity<List<CarFuelTypeDto>> getCarFuelType(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/car-fuelType")
    public ResponseEntity createCarFuelType(){
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/car-fuelType")
    public ResponseEntity<CarFuelTypeDto> updateCarFuelType(@RequestBody CarFuelTypeDto carFuelTypeDto){
        return new ResponseEntity<CarFuelTypeDto>(HttpStatus.OK);
    }

    @DeleteMapping("/car-fuelType/{fuelType_id}")
    public ResponseEntity<CarFuelTypeDto> deleteCarFuelType(@PathVariable(value = "id") Long id){
        return new ResponseEntity<CarFuelTypeDto>(HttpStatus.OK);
    }

}
