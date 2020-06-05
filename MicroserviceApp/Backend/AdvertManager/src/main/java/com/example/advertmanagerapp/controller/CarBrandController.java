package com.example.advertmanagerapp.controller;


import com.example.advertmanagerapp.dto.CarBrandDto;
import com.example.advertmanagerapp.model.CarBrand;
import com.example.advertmanagerapp.service.CarBrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("advert-manager/car-brand")
@RestController
@CrossOrigin
public class CarBrandController {

    private final CarBrandService brandService;

    @GetMapping("/all")
    public List<CarBrand> getCarBrand(){

        return brandService.getAllCarBrand();
    }

    @PostMapping
    public ResponseEntity createCarBrand(@RequestBody CarBrand carBrand){
        brandService.saveCarBrand(carBrand);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CarBrandDto> updateCarBrand(@RequestBody CarBrand carBrand){
        brandService.saveCarBrand(carBrand);
        return new ResponseEntity<CarBrandDto>(HttpStatus.OK);
    }

    @DeleteMapping("/{brand_id}")
    public ResponseEntity<CarBrandDto> deleteCarBrand(@PathVariable(value = "brand_id") Long id){
        brandService.deleteCarBrand(id);
        return new ResponseEntity<CarBrandDto>(HttpStatus.OK);
    }
}
