package bo.edu.ucb.backend.dao;

import bo.edu.ucb.backend.entity.SubjectEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SubjectEvaluationDAO extends JpaRepository<SubjectEvaluation, Integer> {
//    @Query(value = "SELECT subject_evaluation_id " +
//            "FROM SubjectEvaluation se " +
//            "JOIN TeacherSubject ts ON se.teacherSubject.teacherSubjectId = ts.teacherSubjectId " +
//    Integer findSubjectEvaluationIdByTeacherSubject(Integer teacherSubjectId);

}
