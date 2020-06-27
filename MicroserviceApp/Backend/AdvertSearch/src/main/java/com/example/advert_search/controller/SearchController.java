package com.example.advert_search.controller;

import com.example.advert_search.dto.AdvertCopyDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/search-manager")
@RestController
@CrossOrigin
public class SearchController {

    private static final Logger logger = LoggerFactory.getLogger("DebugLogger");
    String className = " [" + SearchController.class.getName() +"] ";

    @PostMapping("/search") //ili Get, razmisliti
    public ResponseEntity<List<AdvertCopyDto>> getUsers(@RequestBody AdvertCopyDto advertCopyDto){
        logger.debug(className + "Preuzmi sve oglase");
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
