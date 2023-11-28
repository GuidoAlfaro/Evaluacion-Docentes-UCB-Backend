package bo.edu.ucb.backend.bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bo.edu.ucb.backend.dao.SubjectEnrollmentDAO;
@Service
public class SubjectEnrollmentBL {
    @Autowired
    private SubjectEnrollmentDAO subjectEnrollmentDAO;

    public void updateEvaluatedStatus(Integer subjectEvaluationId, Integer studentUserId) {
        subjectEnrollmentDAO.updateEvaluatedStatus(subjectEvaluationId, studentUserId);
    }
}
