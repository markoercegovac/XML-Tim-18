package com.example.advertmanagerapp.controller;


import com.example.advertmanagerapp.dto.PriceDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RequiredArgsConstructor
@RequestMapping("/advert-manager/discount")
@RestController
@CrossOrigin
public class DiscountController {

    private static final Logger logger = LoggerFactory.getLogger("DebugLogger");
    String className = " [" + DiscountController.class.getName() +"] ";

    @PostMapping
    public ResponseEntity createDiscount () {
        logger.debug(className + "Kreiraj popust");
        return new ResponseEntity(HttpStatus.OK);
    }

    //nema klase discount??? Gdje smo to ostavili????
}
