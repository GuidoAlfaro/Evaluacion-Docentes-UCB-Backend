package bo.edu.ucb.backend.dao;

import bo.edu.ucb.backend.dto.ChatResponse;
import bo.edu.ucb.backend.entity.DetailedResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DetailedResultDAO extends JpaRepository<DetailedResult, Integer> {
    @Query("SELECT NEW bo.edu.ucb.backend.dto.ChatResponse(dr.messageForTeacher, dr.parameterCalification) " +
            "FROM DetailedResult dr " +
            "JOIN TeacherSubject ts ON dr.teacherSubject.teacherSubjectId = ts.teacherSubjectId")
    List<ChatResponse> findDetailedResultsByTeacherSubjectId(@Param("teacherSubjectId") Integer teacherSubjectId);
}
