package com.comment.manager.manager.service.impl;


import com.comment.manager.manager.model.Grade;
import com.comment.manager.manager.repository.GradeRepository;
import com.comment.manager.manager.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GradeServiceImpl implements GradeService {

        private final GradeRepository gradeRepository;


    @Override
    public void createGrade(Grade grade) {
        System.out.println("/n/n/n/n/n/n/nn/n Bio sam ovde ocena!/n/n/n/n/n/n/n");
        gradeRepository.save(grade);
    }
}
