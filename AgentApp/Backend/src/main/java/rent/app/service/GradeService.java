package rent.app.service;

import org.springframework.stereotype.Service;
import rent.app.model.Grade;

import java.util.List;

@Service
public interface GradeService {

    void addGrade(Grade newGrade);
    void changeGrade(Grade grade);
    List<Grade> getGradeForAd(Long adId);
}
