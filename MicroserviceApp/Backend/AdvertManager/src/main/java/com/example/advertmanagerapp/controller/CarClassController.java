package com.example.advertmanagerapp.controller;


import com.example.advertmanagerapp.dto.CarClassDto;
import com.example.advertmanagerapp.dto.mapper.DtoEntity;
import com.example.advertmanagerapp.service.CarClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("advert-manager/car-class")
@RestController
@CrossOrigin
public class CarClassController {

    private final CarClassService carClassService;

    @GetMapping("/all")
    public ResponseEntity<List<DtoEntity>> getCarClass(){
        return new ResponseEntity<>(carClassService.getAllCarClasses(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createCarClass(@RequestBody CarClassDto carClassDto){
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CarClassDto> updateCarClass(@RequestBody CarClassDto carClassDto){
        return new ResponseEntity<CarClassDto>(HttpStatus.OK);
    }

    @DeleteMapping("/{class_id}")
    public ResponseEntity<CarClassDto> deleteCarClass(@PathVariable(value = "id") Long id){
        return new ResponseEntity<CarClassDto>(HttpStatus.OK);
    }

}
