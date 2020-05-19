package rent.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rent.app.model.Grade;
import rent.app.repository.GradeRepository;
import rent.app.service.GradeService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GradeServiceImpl implements GradeService {

    private final GradeRepository gradeRepository;

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
