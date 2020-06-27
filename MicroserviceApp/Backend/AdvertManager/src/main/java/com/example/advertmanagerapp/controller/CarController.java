package com.example.advertmanagerapp.controller;


import com.example.advertmanagerapp.dto.AdvertDto;
import com.example.advertmanagerapp.dto.CarDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

        private static final Logger logger = LoggerFactory.getLogger("DebugLogger");
        String className = " [" + CarController.class.getName() +"] ";

        @PostMapping
        public ResponseEntity createCar (@RequestBody CarDto carDto) {
                logger.debug(className + "Kreiraj auto sa id: "+ carDto.getId());
                return new ResponseEntity(HttpStatus.OK);
        }


        @GetMapping("/{car_id}")
        public ResponseEntity<CarDto> getCar (@PathParam(value="car_id") Long car_id) {
                logger.debug(className + "Preuzmi auto sa id: "+ car_id);
            return new ResponseEntity<CarDto>(HttpStatus.OK);
        }

        @GetMapping("/{user_id}/all")
        public ResponseEntity<List<CarDto>> getCarsFromOwner (@PathParam(value="user_id") Long user_id) {
                logger.debug(className + "Kreiraj auto sa id: "+ user_id);
            return new ResponseEntity<List<CarDto>>(HttpStatus.OK);
        }

        @PutMapping("/update")
        public ResponseEntity updateCar (@RequestBody CarDto carDto) {
                logger.debug(className + "Izmeni auto sa id: "+ carDto.getId());
        return new ResponseEntity(HttpStatus.OK);
        }

        @DeleteMapping("/{car_id}")
        public ResponseEntity deleteCar (@PathParam(value="car_id") Long car_id) {
                logger.debug(className + "Obrisi auto sa id: "+ car_id);
        return new ResponseEntity(HttpStatus.OK);
        }

        @GetMapping("/car-stat/{user_id}")
        public ResponseEntity getStatistics () {
                logger.debug(className + "Preuzmi statistiku");
                return new ResponseEntity(HttpStatus.OK);
        }

}
