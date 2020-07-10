package com.example.advertmanagerapp.controller.rest;


import com.example.advertmanagerapp.dto.CarDto;
import com.example.advertmanagerapp.dto.PriceDto;
import com.example.advertmanagerapp.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/advert-manager/price")
@RestController
public class PriceController {


    private final PriceService priceService;

    @PostMapping
    public void createPrice (@RequestBody PriceDto price,Principal principal) {
        priceService.savePrice(price,principal.getName());
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
    public ResponseEntity<List<PriceDto>> allPrices (Principal principal) {
        return new ResponseEntity<List<PriceDto>>(priceService.allPrices(principal.getName()),HttpStatus.OK);
    }

}
