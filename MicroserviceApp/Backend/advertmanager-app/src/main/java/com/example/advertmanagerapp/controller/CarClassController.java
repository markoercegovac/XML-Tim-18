package com.example.advertmanagerapp.controller;


import com.example.advertmanagerapp.dto.CarClassDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/car-class")
@RestController
@CrossOrigin
public class CarClassController {

    @GetMapping("/all")
    public ResponseEntity<List<CarClassDto>> getCarClass(){
        return new ResponseEntity<>(HttpStatus.OK);
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
