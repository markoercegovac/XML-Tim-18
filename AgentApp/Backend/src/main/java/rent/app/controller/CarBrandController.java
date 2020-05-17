package rent.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rent.app.model.CarBrand;
import rent.app.service.CarBrandService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/carBrand")
public class CarBrandController {


    private final CarBrandService service;


    @GetMapping("/all")
    public List<CarBrand> all() {
        var allCarBrands = this.service.getAllCarBrands();
        return allCarBrands;
    }

}
