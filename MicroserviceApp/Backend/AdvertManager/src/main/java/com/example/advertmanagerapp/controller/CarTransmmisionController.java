package com.example.advertmanagerapp.controller;


import com.example.advertmanagerapp.dto.CarTransmissionTypeDto;
import com.example.advertmanagerapp.dto.mapper.DtoEntity;
import com.example.advertmanagerapp.service.CarTransmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/advert-manager/car-transmission")
@RestController
@CrossOrigin
public class CarTransmmisionController {

    private final CarTransmissionService carTransmissionService;

    @GetMapping("/all")
    public ResponseEntity<List<DtoEntity>> getCarTransmision(){
        return new ResponseEntity<>(carTransmissionService.getAllTransmissionType(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createCarTransmision(@RequestBody CarTransmissionTypeDto carTransmisionDto){
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CarTransmissionTypeDto> updateCarTransmision(@RequestBody CarTransmissionTypeDto carTransmisionDto){
        return new ResponseEntity<CarTransmissionTypeDto>(HttpStatus.OK);
    }

    @DeleteMapping("/{transmision_id}")
    public ResponseEntity<CarTransmissionTypeDto> deleteCarTransmision(@PathVariable(value = "id") Long id){
        return new ResponseEntity<CarTransmissionTypeDto>(HttpStatus.OK);
    }
}
