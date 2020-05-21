package com.example.advert_search.controller;

import com.example.advert_search.dto.AdvertCopyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/search-manager")
@RestController
@CrossOrigin
public class DataTransferController {

    @PostMapping("/advert-copy")
    public ResponseEntity createAdvertCopy(@RequestBody AdvertCopyDto advertCopy) {

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/advert-copy")
    public ResponseEntity updateAdvertCopy(@RequestBody AdvertCopyDto advertCopy) {

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/advert-copy/{advert_id}")
    public ResponseEntity deleteAdvertCopy(@PathVariable("advert_id") Long advertId) {

        return new ResponseEntity(HttpStatus.OK);
    }
}
