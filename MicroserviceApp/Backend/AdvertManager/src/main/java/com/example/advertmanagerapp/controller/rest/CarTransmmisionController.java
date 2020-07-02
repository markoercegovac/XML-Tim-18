package com.example.advertmanagerapp.controller.rest;


import com.example.advertmanagerapp.dto.CarTransmissionTypeDto;
import com.example.advertmanagerapp.dto.mapper.DtoEntity;
import com.example.advertmanagerapp.model.CarTransmissionType;
import com.example.advertmanagerapp.service.CarTranssmisionTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/advert-manager/car-transmission")
@RestController
public class CarTransmmisionController {

    private final CarTranssmisionTypeService transsmisionTypeService;

    @GetMapping("/all")
    public List<CarTransmissionType> getCarTransmision(){

        return transsmisionTypeService.getAllCarTranssmisionType();

    }

    @PostMapping
    public ResponseEntity createCarTransmision(@RequestBody CarTransmissionType carTransmision){

        carTransmision.setId(null);
        transsmisionTypeService.saveCarTranssmisionType(carTransmision);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CarTransmissionTypeDto> updateCarTransmision(@RequestBody CarTransmissionType carTransmision){


        transsmisionTypeService.saveCarTranssmisionType(carTransmision);
        return new ResponseEntity<CarTransmissionTypeDto>(HttpStatus.OK);
    }

    @DeleteMapping("/{transmision_id}")
    public ResponseEntity<CarTransmissionTypeDto> deleteCarTransmision(@PathVariable(value = "transmision_id") Long id){
        transsmisionTypeService.deleteCarTranssmision(id);
        return new ResponseEntity<CarTransmissionTypeDto>(HttpStatus.OK);
    }
    @GetMapping("/all/v2")
    public ResponseEntity<List<DtoEntity>> getCarTransmisionV2(){
        return new ResponseEntity<>(transsmisionTypeService.getAllTransmissionType(),HttpStatus.OK);
    }
}
