package rent.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rent.app.model.CarBrand;
import rent.app.service.CarService;

import java.util.List;

@RequestMapping("/api/car")
@RequiredArgsConstructor
@RestController
@CrossOrigin
public class CarController {

    private final CarService carService;

    @GetMapping("/allModels")
    public ResponseEntity<List<CarBrand>> getAllModels(){
        return new ResponseEntity<>(carService.getCarBrands(), HttpStatus.OK);
    }
}
