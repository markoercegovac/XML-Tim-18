package rent.app.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger("DebugLogger");
    String className = " [" + GradeController.class.getName() +"] ";

    @GetMapping("/all/{ad_id}")
    public ResponseEntity<List<Grade>> getAllGradesForAd(@PathVariable("ad_id") Long adId) {
        logger.debug(className +" Dobavljanje svih ocena od oglasa sa id: " + adId);
        List<Grade> grades = gradeService.getGradeForAd(adId);

        return new ResponseEntity<List<Grade>>(grades, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addGrade(Grade newGrade) {
        logger.debug(className +" Dodata ocena sa id: " + newGrade.getId());
        gradeService.addGrade(newGrade);

        return new ResponseEntity<String>("CREATED", HttpStatus.CREATED);
    }

}
