package rent.app.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rent.app.dto.CarBrandDto;
import rent.app.model.CarBrand;
import rent.app.service.CarBrandService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car-brand")
@CrossOrigin()
public class CarBrandController {

    private final CarBrandService carBrandService;

    @GetMapping("/all")
    public List<CarBrand> getCarBrand(){

        return carBrandService.getAllCarBrand();
    }

    @PostMapping
    public ResponseEntity createCarBrand(@RequestBody CarBrand carBrand){
        carBrand.setId(null);
        carBrandService.saveCarBrand(carBrand);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateCarBrand(@RequestBody CarBrand carBrand){
        carBrandService.saveCarBrand(carBrand);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{brand_id}")
    public ResponseEntity deleteCarBrand(@PathVariable(value = "brand_id") Long id){
        carBrandService.deleteCarBrand(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
