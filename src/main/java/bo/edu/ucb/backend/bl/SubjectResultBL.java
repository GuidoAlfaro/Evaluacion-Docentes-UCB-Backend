package bo.edu.ucb.backend.bl;

import bo.edu.ucb.backend.dao.SubjectResultDAO;
import bo.edu.ucb.backend.entity.SubjectResult;
import bo.edu.ucb.backend.entity.TeacherSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectResultBL {
    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(SubjectResultBL.class);
    @Autowired
    private SubjectResultDAO subjectResultDAO;
    @Autowired
    private DetailedResultBL detailedResultBL;

    public SubjectResult createSubjectResult(Integer teacherSubjectId) {
        SubjectResult subjectResult = new SubjectResult();

        TeacherSubject teacherSubject = new TeacherSubject();
        teacherSubject.setTeacherSubjectId(teacherSubjectId);
        subjectResult.setTeacherSubject(teacherSubject);
        Double averageCalification = detailedResultBL.getAverageCalification(teacherSubjectId).getAverageCalification();
        LOG.info("El promedio de calificaciones es: {}", averageCalification);
        subjectResult.setOverallResult(averageCalification);
        subjectResult.setTxUser("guidoalfaro");
        subjectResult.setTxHost("192.168.0.0");
        subjectResult.setStatus((short) 1);
        return subjectResultDAO.save(subjectResult);
    }
}
