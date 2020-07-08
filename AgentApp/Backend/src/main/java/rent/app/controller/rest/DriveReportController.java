package rent.app.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rent.app.dto.CommentDTO;
import rent.app.dto.DriveReportDto;
import rent.app.model.DriveReport;
import rent.app.service.DriveReportService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/crud")
public class DriveReportController {

    private final DriveReportService driveReportService;

    //crud operacije za Drive Report
    @GetMapping("/readDR")
    public List<DriveReportDto> getAllDR() {

        List<DriveReportDto> reports = driveReportService.getAllReports();
        return reports;
    }

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
    @PostMapping("/updateDR/{id}")
    public void updateDR(@RequestBody DriveReport dr, @PathVariable(value = "id") Long drId) {

        System.out.println("drU");

    }
    @PostMapping("/deleteDR/{id}")
    public void deleteDR(@PathVariable(value = "id") Long drId,@RequestBody DriveReport dr ) {

        System.out.println("drD");

    }
}
