package com.example.advertmanagerapp.controller;


import com.example.advertmanagerapp.dto.PriceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RequiredArgsConstructor
@RequestMapping("/discount")
@RestController
@CrossOrigin
public class DiscountController {

    @PostMapping
    public ResponseEntity createDiscount () {

        return new ResponseEntity(HttpStatus.OK);
    }

    //nema klase discount??? Gdje smo to ostavili????
}
