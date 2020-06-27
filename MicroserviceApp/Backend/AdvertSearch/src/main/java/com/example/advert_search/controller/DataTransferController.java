package com.example.advert_search.controller;

import com.example.advert_search.dto.AdvertCopyDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/search-manager")
@RestController
@CrossOrigin
public class DataTransferController {

    private static final Logger logger = LoggerFactory.getLogger("DebugLogger");
    String className = " [" + DataTransferController.class.getName() +"] ";

    @PostMapping("/advert-copy")
    public ResponseEntity createAdvertCopy(@RequestBody AdvertCopyDto advertCopy) {
        logger.debug(className + "Kreiraj oglas sa id: "+ advertCopy.getId());
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/advert-copy")
    public ResponseEntity updateAdvertCopy(@RequestBody AdvertCopyDto advertCopy) {
        logger.debug(className + "Izmeni oglas sa id: "+ advertCopy.getId());
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/advert-copy/{advert_id}")
    public ResponseEntity deleteAdvertCopy(@PathVariable("advert_id") Long advertId) {
        logger.debug(className + "Obrisi oglas sa id: "+ advertId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
