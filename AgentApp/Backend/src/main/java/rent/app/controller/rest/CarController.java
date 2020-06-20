package rent.app.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<List<CarBrand>> getAllBrands(){
        return new ResponseEntity<>(carService.getCarBrands(), HttpStatus.OK);
    }

    @GetMapping("/allModels")
    public ResponseEntity<List<CarModel>> getAllModels(){
        return new ResponseEntity<>(carService.getCarModels(),HttpStatus.OK);
    }

    @GetMapping("/allCarClass")
    public ResponseEntity<List<CarClass>> getAllCarClasses(){
        return new ResponseEntity<>(carService.getCarClasses(),HttpStatus.OK);
    }

    @GetMapping("/allTransmissionType")
    public ResponseEntity<List<CarTransmissionType>> getAllTransmissions(){
        return new ResponseEntity<>(carService.getTransmissions(),HttpStatus.OK);
    }

    @GetMapping("/allFuelType")
    public ResponseEntity<List<CarFuelType>> getAllFuelTypes(){
        return new ResponseEntity<>(carService.getFuelTypes(),HttpStatus.OK);
    }

    @PostMapping("/registerCar")
    public void registerCar(@RequestBody Car car){
        System.out.println("Wordks");
    }
}
