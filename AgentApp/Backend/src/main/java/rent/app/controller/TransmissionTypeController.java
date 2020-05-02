package rent.app.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rent.app.model.CarFuelType;
import rent.app.model.CarTransmissionType;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/crud")
public class TransmissionTypeController {

    //crud operacije za CarTransmissionType
    @GetMapping("/readCTT")
    public List<CarTransmissionType> getAllCTT() {

        List<CarTransmissionType> lista= new ArrayList<>();
        CarTransmissionType ctt=new CarTransmissionType((long) 1,"automatski", false);
        CarTransmissionType ctt2=new CarTransmissionType((long) 2,"manuelni", false);
        lista.add(ctt);
        lista.add(ctt2);
        return lista;
    }
    @GetMapping("/readCTT/{id}")
    public CarTransmissionType getById(@PathVariable(value = "id") Long cttId){
        Long id= cttId;
        CarTransmissionType ctt=new CarTransmissionType((long) 1,"automatski", false);
        CarTransmissionType ctt2=new CarTransmissionType((long) 2,"manuelni", false);
        if(id==1){
            return ctt;
        }else return ctt2;
    }

    @PostMapping("/createCTT")
    public void createCtt(@RequestBody CarTransmissionType ctt) {

        System.out.println("eC");

    }
    @PostMapping("/updateCTT/{id}")
    public void updateCtt(@RequestBody CarTransmissionType ctt, @PathVariable(value = "id") Long cttId) {

        System.out.println("eU");

    }
    @PostMapping("/deleteCTT/{id}")
    public void deleteCtt(@PathVariable(value = "id") Long cttId,@RequestBody CarTransmissionType ctt ) {

        System.out.println("eD");

    }
}
