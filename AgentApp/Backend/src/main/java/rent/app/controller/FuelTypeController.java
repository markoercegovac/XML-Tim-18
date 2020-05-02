package rent.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rent.app.model.CarFuelType;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/crud")
public class FuelTypeController {

    //crud operacije za fuel Type
    @GetMapping("/readFT")
    public List<CarFuelType> getAllFT() {

        List<CarFuelType> lista= new ArrayList<>();
        CarFuelType ft=new CarFuelType((long) 1,"benzin", false);
        CarFuelType ft2=new CarFuelType((long) 2,"dizel", false);
        lista.add(ft);
        lista.add(ft2);
        return lista;
    }
    @GetMapping("/readFT/{id}")
    public CarFuelType getByIdFT(@PathVariable(value = "id") Long ftId){
        Long id= ftId;
        CarFuelType ft=new CarFuelType((long) 1,"benzin", false);
        CarFuelType ft2=new CarFuelType((long) 2,"dizel", false);
        if(id==1){
            return ft;
        }else return ft2;
    }

    @PostMapping("/createFT")
    public void createFt(@RequestBody CarFuelType ft) {

        System.out.println("ftC");

    }
    @PostMapping("/updateFT/{id}")
    public void updateFt(@RequestBody CarFuelType ft, @PathVariable(value = "id") Long ftId) {

        System.out.println("ftU");

    }
    @PostMapping("/deleteFT/{id}")
    public void deleteFt(@PathVariable(value = "id") Long ftId,@RequestBody CarFuelType ft ) {

        System.out.println("ftD");

    }
}
