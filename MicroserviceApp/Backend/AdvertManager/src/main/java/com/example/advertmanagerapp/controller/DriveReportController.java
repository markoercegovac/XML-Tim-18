package com.example.advertmanagerapp.controller;


import com.example.advertmanagerapp.dto.DriveReportDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/advert-manager/car-report")
@RestController
@CrossOrigin
public class DriveReportController {

    private static final Logger logger = LoggerFactory.getLogger("DebugLogger");
    String className = " [" + DriveReportController.class.getName() +"] ";

    @GetMapping("/{car_id}")
    public ResponseEntity<DriveReportDto> getDriveReport (@PathVariable(value="car_id") Long car_id) {
        logger.debug(className + "Preuzmi izvestaj sa id:" +car_id );
        return new ResponseEntity<DriveReportDto>(HttpStatus.OK);
    }

    @PostMapping("/{car_id}")
    public ResponseEntity createDriveReport (@PathVariable(value="car_id") Long car_id){
        logger.debug(className + "Kreiraj izvestaj sa id:" +car_id );
        return new ResponseEntity(HttpStatus.OK);
    }
}
