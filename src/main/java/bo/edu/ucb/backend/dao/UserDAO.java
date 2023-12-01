package bo.edu.ucb.backend.dao;

import bo.edu.ucb.backend.dto.StudentSubjectsDTO;
import bo.edu.ucb.backend.dto.TeacherSubjectsDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import bo.edu.ucb.backend.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Integer>{
    User findByEmail(String email);
    @Query("SELECT new bo.edu.ucb.backend.dto.StudentSubjectsDTO(se.enrollmentId, ts.teacher.userId, u.firstNames, u.lastNames, s.subjectId, s.name, s.semester, s.year, s.parallel, se.evaluated) " +
            "FROM SubjectEnrollment se " +
            "JOIN TeacherSubject ts ON se.subject.subjectId = ts.subject.subjectId " +
            "JOIN User u ON ts.teacher.userId = u.userId " +
            "JOIN Subject s ON se.subject.subjectId = s.subjectId " +
            "WHERE se.student.userId = :studentId AND se.status = 1 AND ts.status = 1")
    List<StudentSubjectsDTO> getStudentSubjectsById(@Param("studentId") Integer studentId);

//    @Query("SELECT new bo.edu.ucb.backend.dto.TeacherSubjectsDTO(ts.teacherSubjectId, ts.subject.subjectId, s.name, ts.subject.parallel, 'default_value') " +
//            "FROM TeacherSubject ts " +
//            "JOIN Subject s ON ts.subject.subjectId = s.subjectId " +
//            "WHERE ts.teacher.userId = :teacherId AND ts.status = 1")
//    List<TeacherSubjectsDTO> getTeacherSubjects(@Param("teacherId") Integer teacherId);
//
//    @Query("SELECT " +
//            "SUM(CASE WHEN se.evaluated = true THEN 1 ELSE 0 END) * 100.0 / COUNT(se) " +
//            "FROM SubjectEnrollment se " +
//            "WHERE se.subject.subjectId = :subjectId")
//    Double calculateEvaluationPercentage(@Param("subjectId") Integer subjectId);
    @Query("SELECT new bo.edu.ucb.backend.dto.TeacherSubjectsDTO(ts.teacherSubjectId, ts.subject.subjectId, s.name, ts.subject.parallel, " +
            "CONCAT(COALESCE(CONCAT(ROUND(SUM(CASE WHEN se.evaluated = true THEN 1 ELSE 0 END) * 100.0 / NULLIF(COUNT(se), 0), 2), '%'), '0'), '%')) " +
            "FROM TeacherSubject ts " +
            "JOIN Subject s ON ts.subject.subjectId = s.subjectId " +
            "LEFT JOIN SubjectEnrollment se ON ts.subject.subjectId = se.subject.subjectId AND se.subject.subjectId = ts.subject.subjectId " +
            "WHERE ts.teacher.userId = :teacherId AND ts.status = 1 " +
            "GROUP BY ts.teacherSubjectId, ts.subject.subjectId, s.name, ts.subject.parallel")
    List<TeacherSubjectsDTO> getTeacherSubjects(@Param("teacherId") Integer teacherId);

}