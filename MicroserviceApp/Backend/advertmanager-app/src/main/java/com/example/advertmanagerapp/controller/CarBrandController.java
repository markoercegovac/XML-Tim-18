package com.example.advertmanagerapp.controller;


import com.example.advertmanagerapp.dto.CarBrandDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/car-brand")
@RestController
@CrossOrigin
public class CarBrandController {


    @GetMapping("/all")
    public ResponseEntity<List<CarBrandDto>> getCarBrand(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createCarBrand(@RequestBody CarBrandDto carBrandDto){
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CarBrandDto> updateCarBrand(@RequestBody CarBrandDto carBrandDto){
        return new ResponseEntity<CarBrandDto>(HttpStatus.OK);
    }

    @DeleteMapping("/{brand_id}")
    public ResponseEntity<CarBrandDto> deleteCarBrand(@PathVariable(value = "id") Long id){
        return new ResponseEntity<CarBrandDto>(HttpStatus.OK);
    }
}
