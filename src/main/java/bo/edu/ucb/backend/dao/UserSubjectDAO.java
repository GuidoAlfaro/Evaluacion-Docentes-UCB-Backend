package bo.edu.ucb.backend.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import bo.edu.ucb.backend.dto.StudentSubjects;
import bo.edu.ucb.backend.entity.UserSubject;

public interface UserSubjectDAO extends JpaRepository<UserSubject, Integer> {
    
    @Query("SELECT new bo.edu.ucb.backend.dto.MateriasAlumnoDTO(" +
            "us.userSubjectId, " +
            "us.teacherUserId.userId, " +
            "us.teacherUserId.firstName, " +
            "us.teacherUserId.lastName, " +
            "us.subjectId.subjectId, " +
            "us.subjectId.name, " +
            "us.semester, " +
            "us.year, " +
            "us.parallel, " +
            "us.evaluated) " +
            "FROM UserSubject us " +
            "WHERE us.studentUserId.userId = :studentId")
    List<StudentSubjects> findSubjectsByStudentId(@Param("studentId") Integer studentId);
}
