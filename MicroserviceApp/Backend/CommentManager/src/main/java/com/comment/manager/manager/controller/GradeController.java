package com.comment.manager.manager.controller;

import com.comment.manager.manager.dto.GradeDto;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/comment-manager")
@RestController
@CrossOrigin
public class GradeController {

    @GetMapping("/grade/{idAdvert")
    public ResponseEntity<List<GradeDto>> showAdvertGrades(@PathVariable Long idAdvert){
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/grade")
    public ResponseEntity<GradeDto> rateAdvert(@RequestBody GradeDto gradeDto){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
