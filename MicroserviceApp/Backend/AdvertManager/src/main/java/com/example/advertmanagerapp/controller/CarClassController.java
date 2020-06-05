package com.example.advertmanagerapp.controller;


import com.example.advertmanagerapp.dto.CarClassDto;
import com.example.advertmanagerapp.model.CarClass;
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

    private final CarClassService classService;

    @GetMapping("/all")
    public List<CarClass> getCarClass()

    {
        return classService.getAllCarClass();
    }

    @PostMapping
    public ResponseEntity createCarClass(@RequestBody CarClass carClass){
        classService.saveCarClass(carClass);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateCarClass(@RequestBody CarClass carClass){
        classService.saveCarClass(carClass);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{class_id}")
    public ResponseEntity<CarClassDto> deleteCarClass(@PathVariable(value = "class_id") Long id){
        classService.deleteCarClass(id);
        return new ResponseEntity<CarClassDto>(HttpStatus.OK);
    }

}
