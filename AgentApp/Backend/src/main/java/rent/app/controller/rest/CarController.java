package rent.app.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rent.app.dto.*;
import rent.app.model.*;
import rent.app.service.CarService;

import java.util.List;

@RequestMapping("/api/car")
@RequiredArgsConstructor
@RestController
@CrossOrigin
public class CarController {

    private final CarService carService;

    @GetMapping("/allBrands")
    public ResponseEntity<List<DTOEntity>> getAllBrands(){
        return new ResponseEntity<>(carService.getCarBrands(), HttpStatus.OK);
    }

    @GetMapping("/allModels")
    public ResponseEntity<List<DTOEntity>> getAllModels(){
        return new ResponseEntity<>(carService.getCarModels(),HttpStatus.OK);
    }

    @GetMapping("/allCarClass")
    public ResponseEntity<List<DTOEntity>> getAllCarClasses(){
        return new ResponseEntity<>(carService.getCarClasses(),HttpStatus.OK);
    }

    @GetMapping("/allTransmissionType")
    public ResponseEntity<List<DTOEntity>> getAllTransmissions(){
        return new ResponseEntity<>(carService.getTransmissions(),HttpStatus.OK);
    }

    @GetMapping("/allFuelType")
    public ResponseEntity<List<DTOEntity>> getAllFuelTypes(){
        return new ResponseEntity<>(carService.getFuelTypes(),HttpStatus.OK);
    }

    @PostMapping("/registerCar")
    public void registerCar(@RequestBody CarDto car){
        carService.createCar(car);
    }

    @GetMapping("/allCars")
    public ResponseEntity<List<CarDtoMini>> getAllCars(){
        return new ResponseEntity<>(carService.allCars(),HttpStatus.OK);
    }
}
