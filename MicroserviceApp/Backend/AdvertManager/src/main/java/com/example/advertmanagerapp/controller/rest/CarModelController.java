package com.example.advertmanagerapp.controller.rest;


import com.example.advertmanagerapp.dto.CarModelDto;
import com.example.advertmanagerapp.model.CarModel;
import com.example.advertmanagerapp.service.CarModelService;
import com.example.advertmanagerapp.dto.mapper.DtoEntity;
import com.example.advertmanagerapp.dto.mapper.DtoUtils;
import com.example.advertmanagerapp.service.CarModelService;
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

    private final CarModelService modelService;

    @GetMapping("/all")
    public List<CarModel> getCarModel(){

        return modelService.getAllCarModel();
    }

    @PostMapping
    public ResponseEntity createCarModel(@RequestBody CarModel carModel){

        modelService.saveCarModel(carModel);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CarModelDto> updateCarModel(@RequestBody CarModel carModel){
        modelService.saveCarModel(carModel);
        return new ResponseEntity<CarModelDto>(HttpStatus.OK);
    }

    @DeleteMapping("/{model_id}")
    public ResponseEntity<CarModelDto> deleteCarModel(@PathVariable(value = "model_id") Long id){
        modelService.deleteCarModel(id);
        return new ResponseEntity<CarModelDto>(HttpStatus.OK);
    }
    @GetMapping("/all/v2/{id}")
    public ResponseEntity<List<DtoEntity>> getCarModelV2(@PathVariable("id") Long id){
        return new ResponseEntity<>(modelService.getModelForBrand(id),HttpStatus.OK);
    }
}

