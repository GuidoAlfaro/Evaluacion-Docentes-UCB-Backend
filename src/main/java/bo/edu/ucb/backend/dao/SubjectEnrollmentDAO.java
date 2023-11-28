package bo.edu.ucb.backend.dao;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import bo.edu.ucb.backend.entity.SubjectEnrollment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SubjectEnrollmentDAO extends JpaRepository<SubjectEnrollment, Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE SubjectEnrollment se " +
            "SET se.evaluated = true " +
            "WHERE se.subject.subjectId = (SELECT sev.subject.subjectId FROM SubjectEvaluation sev WHERE sev.subjectEvaluationId = :subjectEvaluationId) " +
            "AND se.student.userId = :studentUserId")
    void updateEvaluatedStatus(@Param("subjectEvaluationId") Integer subjectEvaluationId, @Param("studentUserId") Integer studentUserId);
}