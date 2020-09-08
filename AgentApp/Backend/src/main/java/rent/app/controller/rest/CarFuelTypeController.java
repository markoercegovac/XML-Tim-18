package rent.app.controller.rest;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rent.app.dto.CarFuelTypeDto;
import rent.app.model.CarFuelType;
import rent.app.service.CarFuelTypeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car-fuel-type")
@CrossOrigin()
public class CarFuelTypeController {

    private final CarFuelTypeService fuelTypeService;


    @GetMapping("/all")
    public List<CarFuelType> getCarFuelType(){

        return fuelTypeService.getAllCarFuelType();
    }

    @PostMapping
    public ResponseEntity createCarFuelType(@RequestBody CarFuelType carFuelType){
        carFuelType.setId(null);
        fuelTypeService.saveFuelType(carFuelType);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateCarFuelType(@RequestBody CarFuelType carFuelType){
        fuelTypeService.saveFuelType(carFuelType);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{fuelType_id}")
    public ResponseEntity<CarFuelTypeDto> deleteCarFuelType(@PathVariable(value = "fuelType_id") Long id){
        fuelTypeService.deleteFuelTypeService(id);
        return new ResponseEntity<CarFuelTypeDto>(HttpStatus.OK);
    }
}
