package bo.edu.ucb.backend.dao;

import bo.edu.ucb.backend.dto.TeacherQueryDTO;
import bo.edu.ucb.backend.entity.TeacherQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeacherQueryDAO extends JpaRepository<TeacherQuery, Integer> {
    @Query("SELECT NEW bo.edu.ucb.backend.dto.TeacherQueryDTO(t.teacherQueryId, t.queryText, t.apiResponse, t.date) " +
            "FROM TeacherQuery t " +
            "JOIN t.teacherSubject ts " +
            "WHERE ts.teacherSubjectId = :teacherSubjectId " +
            "AND t.status = 1"
    )
    List<TeacherQueryDTO> findAllTeacherQuery(@Param("teacherSubjectId") Integer teacherSubjectId);
}
