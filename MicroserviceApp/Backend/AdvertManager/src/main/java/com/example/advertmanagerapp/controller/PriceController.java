package com.example.advertmanagerapp.controller;


import com.example.advertmanagerapp.dto.CarDto;
import com.example.advertmanagerapp.dto.PriceDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/advert-manager/price")
@RestController
@CrossOrigin
public class PriceController {

    private static final Logger logger = LoggerFactory.getLogger("DebugLogger");
    String className = " [" + PriceController.class.getName() +"] ";

    @PostMapping
    public ResponseEntity createPrice (@RequestBody PriceDto priceDto) {
        logger.debug(className + "Kreiraj cenu sa imenom:" + priceDto.getName());
        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping("/{price_id}")
    public ResponseEntity<PriceDto> getPrice (@PathParam(value="price_id") Long price_id) {
        logger.debug(className + "Preuzmi cenu sa id:" + price_id);
        return new ResponseEntity<PriceDto>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity updatePrice (@RequestBody PriceDto priceDto) {
        logger.debug(className + "Izmeni cenu sa imenom:" + priceDto.getName());
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{price_id}")
    public ResponseEntity deletePrice (@PathParam(value="price_id") Long price_id) {
        logger.debug(className + "Obrisi cenu sa imenom:" + price_id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PriceDto>> allPrices () {
        logger.debug(className + "Preuzmi sve cene");
        return new ResponseEntity<List<PriceDto>>(HttpStatus.OK);
    }

}
