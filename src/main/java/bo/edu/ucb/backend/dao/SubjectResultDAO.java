package bo.edu.ucb.backend.dao;

import bo.edu.ucb.backend.dto.RankingDTO;
import bo.edu.ucb.backend.dto.TeacherSubjectsDTO;
import bo.edu.ucb.backend.entity.SubjectResult;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubjectResultDAO extends JpaRepository<SubjectResult, Integer> {

    //FIXME: NO SE SI ESTO DEBA IR AQUI
    //ranking de docentes
    @Query("SELECT NEW bo.edu.ucb.backend.dto.RankingDTO(ts.teacher.firstNames, ts.teacher.lastNames, ts.subject.name, ts.subject.parallel, sr.overAllCalification) " +
            "FROM TeacherSubject ts " +
            "JOIN Subject s ON ts.subject.subjectId = s.subjectId " +
            "JOIN User u ON ts.teacher.userId = u.userId " +
            "JOIN SubjectResult sr ON ts.teacherSubjectId = sr.teacherSubject.teacherSubjectId " +
            "ORDER BY sr.overAllCalification DESC")
    List<RankingDTO> getRanking(Pageable pageable);

}
