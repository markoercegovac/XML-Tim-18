package com.example.advertmanagerapp.controller;


import com.example.advertmanagerapp.dto.CarModelDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/advert-manager/car-model")
@RestController
@CrossOrigin
public class CarModelController {

    @GetMapping("/all")
    public ResponseEntity<List<CarModelDto>> getCarModel(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createCarModel(@RequestBody CarModelDto carModelDto){
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CarModelDto> updateCarModel(@RequestBody CarModelDto carModelDto){
        return new ResponseEntity<CarModelDto>(HttpStatus.OK);
    }

    @DeleteMapping("/{model_id}")
    public ResponseEntity<CarModelDto> deleteCarModel(@PathVariable(value = "id") Long id){
        return new ResponseEntity<CarModelDto>(HttpStatus.OK);
    }
}

