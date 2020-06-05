package com.example.advertmanagerapp.controller;


import com.example.advertmanagerapp.dto.CarBrandDto;
import com.example.advertmanagerapp.dto.mapper.DtoEntity;
import com.example.advertmanagerapp.repository.CarBrandRepository;
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

    private final CarBrandService carBrandService;

    @GetMapping("/all")
    public ResponseEntity<List<DtoEntity>> getCarBrand(){
        return new ResponseEntity<>(carBrandService.getAllBrands(),HttpStatus.OK);
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
