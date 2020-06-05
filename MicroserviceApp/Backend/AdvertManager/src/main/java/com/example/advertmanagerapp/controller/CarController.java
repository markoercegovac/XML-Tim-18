package com.example.advertmanagerapp.controller;


import com.example.advertmanagerapp.dto.AdvertDto;
import com.example.advertmanagerapp.dto.CarDto;
import com.example.advertmanagerapp.dto.mapper.DtoEntity;
import com.example.advertmanagerapp.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/advert-manager/car")
@RestController
@CrossOrigin
public class CarController {

        private final CarService carService;

        @PostMapping
        public void createCar (@RequestBody CarDto carDto) {
            carService.createCar(carDto);
        }


        @GetMapping("/{car_id}")
        public ResponseEntity<CarDto> getCar (@PathParam(value="car_id") Long car_id) {
            return new ResponseEntity<CarDto>(HttpStatus.OK);
        }

        @GetMapping("/all")
        public ResponseEntity<List<DtoEntity>> getCarsFromOwner () {
            return new ResponseEntity<>(carService.getAllCars(),HttpStatus.OK);
        }

        @PutMapping("/update")
        public ResponseEntity updateCar (@RequestBody CarDto carDto) {

        return new ResponseEntity(HttpStatus.OK);
        }

        @DeleteMapping("/{car_id}")
        public ResponseEntity deleteCar (@PathParam(value="car_id") Long car_id) {

        return new ResponseEntity(HttpStatus.OK);
        }

        @GetMapping("/car-stat/{user_id}")
        public ResponseEntity getStatistics () {

                return new ResponseEntity(HttpStatus.OK);
        }

}
