package com.example.advert_search.controller;

import com.example.advert_search.dto.AdvertCopyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/search-manager")
@RestController
@CrossOrigin
public class SearchController {

    @PostMapping("/search") //ili Get, razmisliti
    public ResponseEntity<List<AdvertCopyDto>> getUsers(@RequestBody AdvertCopyDto advertCopyDto){
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
