package rent.app.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rent.app.dto.CarTransmissionTypeDto;
import rent.app.model.CarTransmissionType;
import rent.app.service.CarTranssmisionTypeService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/car-transsmision-type")
@CrossOrigin()
public class CarTranssmisionTypeController {


    private final CarTranssmisionTypeService transsmisionTypeService;

    @GetMapping("/all")
    public List<CarTransmissionType> getCarTransmision(){

        return transsmisionTypeService.getAllCarTranssmisionType();

    }

    @PostMapping
    public ResponseEntity createCarTransmision(@RequestBody CarTransmissionType carTransmision){

        carTransmision.setId(null);
        transsmisionTypeService.saveCarTranssmisionType(carTransmision);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CarTransmissionTypeDto> updateCarTransmision(@RequestBody CarTransmissionType carTransmision){


        transsmisionTypeService.saveCarTranssmisionType(carTransmision);
        return new ResponseEntity<CarTransmissionTypeDto>(HttpStatus.OK);
    }

    @DeleteMapping("/{transmision_id}")
    public ResponseEntity<CarTransmissionTypeDto> deleteCarTransmision(@PathVariable(value = "transmision_id") Long id){
        transsmisionTypeService.deleteCarTranssmision(id);
        return new ResponseEntity<CarTransmissionTypeDto>(HttpStatus.OK);
    }
}
