package rent.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rent.app.model.Grade;
import rent.app.service.GradeService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/grades")
@CrossOrigin(origins = "http://localhost:4200")
public class GradeController {

    private final GradeService gradeService;

    @GetMapping("/all/{ad_id}")
    public ResponseEntity<List<Grade>> getAllGradesForAd(@PathVariable("ad_id") Long adId) {
        List<Grade> grades = gradeService.getGradeForAd(adId);

        return new ResponseEntity<List<Grade>>(grades, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addGrade(Grade newGrade) {
        gradeService.addGrade(newGrade);

        return new ResponseEntity<String>("CREATED", HttpStatus.CREATED);
    }

}
