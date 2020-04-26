package rent.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rent.app.model.Grade;
import rent.app.repository.GradeRepository;
import rent.app.service.GradeService;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    private GradeRepository gradeRepository;

    @Autowired
    public GradeServiceImpl(GradeRepository repository) {
        this.gradeRepository = repository;
    }

    @Override
    public void addGrade(Grade newGrade) {
        gradeRepository.save(newGrade);
    }

    @Override
    public void changeGrade(Grade changedGrade) {
//        if(gradeRepository.existsById(changedGrade.())) {
//
//        }
    }

    @Override
    public List<Grade> getGradeForAd(Long adId) {
        return gradeRepository.findAllByAdvertId(adId);
    }
}
