package rent.app.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rent.app.dto.CarClassDto;
import rent.app.model.CarClass;
import rent.app.service.CarClassService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car-class")
@CrossOrigin()
public class CarClassController {


    private final CarClassService classService;

    @GetMapping("/all")
    public List<CarClass> getCarClass()

    {
        return classService.getAllCarClass();
    }

    @PostMapping
    public ResponseEntity createCarClass(@RequestBody CarClass carClass){
        carClass.setId(null);
        classService.saveCarClass(carClass);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateCarClass(@RequestBody CarClass carClass){
        classService.saveCarClass(carClass);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{class_id}")
    public ResponseEntity<CarClassDto> deleteCarClass(@PathVariable(value = "class_id") Long id){
        classService.deleteCarClass(id);
        return new ResponseEntity<CarClassDto>(HttpStatus.OK);
    }

}
