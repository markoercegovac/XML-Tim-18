package com.example.advertmanagerapp.controller.rest;


import com.example.advertmanagerapp.dto.CarBrandDto;
import com.example.advertmanagerapp.dto.mapper.DtoEntity;
import com.example.advertmanagerapp.repository.CarBrandRepository;
import com.example.advertmanagerapp.service.CarBrandService;
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

    private final CarBrandService carBrandService;

    @GetMapping("/all")
    public List<CarBrand> getCarBrand(){

        return carBrandService.getAllCarBrand();
    }

    @PostMapping
    public ResponseEntity createCarBrand(@RequestBody CarBrand carBrand){
        carBrand.setId(null);
        carBrandService.saveCarBrand(carBrand);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CarBrandDto> updateCarBrand(@RequestBody CarBrand carBrand){
        carBrandService.saveCarBrand(carBrand);
        return new ResponseEntity<CarBrandDto>(HttpStatus.OK);
    }

    @DeleteMapping("/{brand_id}")
    public ResponseEntity<CarBrandDto> deleteCarBrand(@PathVariable(value = "brand_id") Long id){
        carBrandService.deleteCarBrand(id);
        return new ResponseEntity<CarBrandDto>(HttpStatus.OK);
    }
    @GetMapping("/all/v2")
    public ResponseEntity<List<DtoEntity>> getCarBrandV2(){
        return new ResponseEntity<>(carBrandService.getAllBrands(),HttpStatus.OK);
    }
}
