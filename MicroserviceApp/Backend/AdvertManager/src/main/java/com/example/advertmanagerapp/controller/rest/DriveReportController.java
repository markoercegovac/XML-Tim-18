package com.example.advertmanagerapp.controller.rest;

import com.example.advertmanagerapp.dto.CarDto;
import com.example.advertmanagerapp.dto.DriveReportDto;
import com.example.advertmanagerapp.service.CarService;
import com.example.advertmanagerapp.service.DriveReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/advert-manager")
public class DriveReportController {
    private final DriveReportService driveReportService;
    private final CarService carService;

    @GetMapping("/readDR/{id}")
    public List<DriveReportDto> getByIdDR(@PathVariable(value = "id") Long drId){

        List<DriveReportDto> reports = driveReportService.getAllReportsByCarId(drId);
        return reports;
    }


    @PostMapping("/createDR")
    public ResponseEntity<?> createDR(@RequestBody DriveReportDto report) {

        driveReportService.addNewReport(report);

        return new ResponseEntity<>( HttpStatus.OK);

    }

    @GetMapping("/allCars")
    public List<CarDto> getAllCars(){

        List<CarDto> cars = carService.getAllConcreteCar();
        return cars;
    }
}
