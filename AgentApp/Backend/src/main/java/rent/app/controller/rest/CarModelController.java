package rent.app.controller.rest;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rent.app.dto.CarModelDto;
import rent.app.model.CarModel;
import rent.app.service.CarModelService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/car-model")
@CrossOrigin()
public class CarModelController {


    private final CarModelService modelService;

    @GetMapping("/all")
    public List<CarModel> getCarModel(){

        return modelService.getAllCarModel();
    }

    @PostMapping
    public ResponseEntity createCarModel(@RequestBody CarModel carModel){
        carModel.setId(null);
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
}
