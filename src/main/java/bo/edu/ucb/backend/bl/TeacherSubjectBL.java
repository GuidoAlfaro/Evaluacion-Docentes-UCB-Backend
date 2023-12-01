package bo.edu.ucb.backend.bl;

import bo.edu.ucb.backend.dao.TeacherSubjectDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherSubjectBL {
    @Autowired
    private TeacherSubjectDAO teacherSubjectDAO;

    public Integer findTeacherSubjectIdBySubjectEvaluation(Integer subjectEvaluationId) {
        return teacherSubjectDAO.findTeacherSubjectIdBySubjectEvaluation(subjectEvaluationId);
    }
}
