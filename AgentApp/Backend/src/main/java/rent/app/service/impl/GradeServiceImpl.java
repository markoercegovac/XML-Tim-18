package rent.app.service.impl;

import lombok.RequiredArgsConstructor;
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
    public float getGradeForAd(Long adId) {
        List<Grade>  grades=gradeRepository.findAllByAdvertId(adId);

        float br=0;

        for(Grade g: grades){
            br+=g.getGrade();
        }
        return br/grades.size();
    }
}
