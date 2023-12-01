package bo.edu.ucb.backend.dao;

import bo.edu.ucb.backend.entity.TeacherSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TeacherSubjectDAO extends JpaRepository<TeacherSubject, Integer> {
    @Query("SELECT ts.teacherSubjectId FROM TeacherSubject ts, SubjectEvaluation se " +
            "WHERE se.subject.subjectId = ts.subject.subjectId " +
            "AND se.subjectEvaluationId = :subjectEvaluationId")
    Integer findTeacherSubjectIdBySubjectEvaluation(
            @Param("subjectEvaluationId") Integer subjectEvaluationId
    );

    @Query("SELECT se.subjectEvaluationId FROM TeacherSubject ts, SubjectEvaluation se " +
            "WHERE se.subject.subjectId = ts.subject.subjectId " +
            "AND ts.teacherSubjectId = :teacherSubjectId")
    Integer findSubjectEvaluationByTeacherSubjectId(
            @Param("teacherSubjectId") Integer teacherSubjectId
    );

}