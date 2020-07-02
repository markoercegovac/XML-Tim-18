package com.example.advertmanagerapp.controller.rest;


import com.example.advertmanagerapp.dto.DriveReportDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/advert-manager/car-report")
@RestController
public class DriveReportController {

    @GetMapping("/{car_id}")
    public ResponseEntity<DriveReportDto> getDriveReport () {

        return new ResponseEntity<DriveReportDto>(HttpStatus.OK);
    }

    @PostMapping("/{car_id}")
    public ResponseEntity createDriveReport (@PathVariable(value="car_id") Long car_id){

        return new ResponseEntity(HttpStatus.OK);
    }
}
