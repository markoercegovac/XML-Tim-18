package rent.app.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger("DebugLogger");
    String className = " [" + CarController.class.getName() +"] ";

    @GetMapping("/allBrands")
    public ResponseEntity<List<CarBrand>> getAllBrands(){
        logger.debug(className +" Dobavljanje svih brendova");
        logger.debug(className + "Ukupno brendova: " + carService.getCarBrands().size());
        return new ResponseEntity<>(carService.getCarBrands(), HttpStatus.OK);
    }

    @GetMapping("/allModels")
    public ResponseEntity<List<CarModel>> getAllModels(){
        logger.debug(className + "Ukupno modela: " + carService.getCarModels().size());
        return new ResponseEntity<>(carService.getCarModels(),HttpStatus.OK);
    }

    @GetMapping("/allCarClass")
    public ResponseEntity<List<CarClass>> getAllCarClasses(){
        logger.debug(className + "Ukupno klasa: " + carService.getCarClasses().size());
        return new ResponseEntity<>(carService.getCarClasses(),HttpStatus.OK);
    }

    @GetMapping("/allTransmissionType")
    public ResponseEntity<List<CarTransmissionType>> getAllTransmissions(){
        logger.debug(className + "Ukupno tipova menjaca: " + carService.getTransmissions().size());
        return new ResponseEntity<>(carService.getTransmissions(),HttpStatus.OK);
    }

    @GetMapping("/allFuelType")
    public ResponseEntity<List<CarFuelType>> getAllFuelTypes(){
        logger.debug(className + "Ukupno vrsta goriva: " + carService.getFuelTypes().size());
        return new ResponseEntity<>(carService.getFuelTypes(),HttpStatus.OK);
    }

    @PostMapping("/registerCar")
    public void registerCar(@RequestBody Car car){
        logger.debug(className + "Registracija novog automobila sa id: "+ car.getId());
        System.out.println("Wordks");
    }
}
