package bo.edu.ucb.backend.dao;

import bo.edu.ucb.backend.dto.StudentSubjectsDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import bo.edu.ucb.backend.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Integer>{
    User findByEmail(String email);
    @Query("SELECT new bo.edu.ucb.backend.dto.StudentSubjectsDTO(se.enrollmentId, ts.teacherUserId.userId, u.firstName, u.lastName, s.subjectId, s.name, s.semester, s.year, s.parallel, se.evaluated) " +
            "FROM SubjectEnrollment se " +
            "JOIN TeacherSubject ts ON se.subjectId.subjectId = ts.subjectId.subjectId " +
            "JOIN User u ON ts.teacherUserId.userId = u.userId " +
            "JOIN Subject s ON se.subjectId.subjectId = s.subjectId " +
            "WHERE se.studentUserId.userId = :studentId AND se.status = true AND ts.status = true")
    List<StudentSubjectsDTO> getStudentSubjectsById(@Param("studentId") Integer studentId);

}