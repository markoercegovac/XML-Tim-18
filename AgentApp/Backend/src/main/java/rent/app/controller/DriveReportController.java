package rent.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rent.app.model.DriveReport;

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

    Date date1 = new Date();
    Date date2 = new Date();
    //crud operacije za Drive Report
    @GetMapping("/readDR")
    public List<DriveReport> getAllDR() {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String dateInString = "7-Jun-2019";
        String dateInString2 = "20-Jun-2019";
        try{
            date1 = formatter.parse(dateInString);
            date2 = formatter.parse(dateInString2);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        List<DriveReport> lista= new ArrayList<>();
        DriveReport dr = new DriveReport((long) 1, (float) 100.5, "lalala", date1);
        DriveReport dr2 = new DriveReport((long) 2, (float) 100.5, "lalala", date2);
        lista.add(dr);
        lista.add(dr2);
        return lista;
    }
    @GetMapping("/readDR/{id}")
    public DriveReport getByIdDR(@PathVariable(value = "id") Long drId){

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String dateInString = "7-Jun-2019";
        String dateInString2 = "20-Jun-2019";
        try{
            date1 = formatter.parse(dateInString);
            date2 = formatter.parse(dateInString2);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }

        Long id= drId;
        DriveReport dr = new DriveReport((long) 1, (float) 100.5, "lalala", date1);
        DriveReport dr2 = new DriveReport((long) 2, (float) 100.5, "lalala", date2);
        if(id==1){
            return dr;
        }else return dr2;
    }

    @PostMapping("/createDR")
    public void createDR(@RequestBody DriveReport dr) {

        System.out.println("drC");

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
