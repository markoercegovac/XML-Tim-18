package com.example.advertmanagerapp.controller;


import com.example.advertmanagerapp.dto.CarDto;
import com.example.advertmanagerapp.dto.PriceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/price")
@RestController
@CrossOrigin
public class PriceController {


    @PostMapping
    public ResponseEntity createPrice (@RequestBody PriceDto priceDto) {

        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping("/{price_id}")
    public ResponseEntity<PriceDto> getPrice (@PathParam(value="price_id") Long price_id) {
        return new ResponseEntity<PriceDto>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity updatePrice (@RequestBody PriceDto priceDto) {

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{price_id}")
    public ResponseEntity deletePrice (@PathParam(value="price_id") Long price_id) {

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PriceDto>> allPrices () {
        return new ResponseEntity<List<PriceDto>>(HttpStatus.OK);
    }

}
