package com.comment.manager.manager.controller;

import com.comment.manager.manager.dto.GradeDto;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/comment-manager")
@RestController
@CrossOrigin
public class GradeController {

    private static final Logger logger = LoggerFactory.getLogger("DebugLogger");
    String className = " [" + GradeController.class.getName() +"] ";

    @GetMapping("/grade/{idAdvert}")
    public ResponseEntity<List<GradeDto>> showAdvertGrades(@PathVariable Long idAdvert){
        logger.debug(className + "Prikazi ocene oglasa sa id: "+ idAdvert);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/grade")
    public ResponseEntity<GradeDto> rateAdvert(@RequestBody GradeDto gradeDto){
        logger.debug(className + "Oceni oglas sa ocenom sa id: "+ gradeDto.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
