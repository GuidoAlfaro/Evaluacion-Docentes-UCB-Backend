package bo.edu.ucb.backend.dao;

import bo.edu.ucb.backend.dto.StudentSubjectsDTO;
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

}