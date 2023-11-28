package bo.edu.ucb.backend.dao;

import bo.edu.ucb.backend.entity.TeacherSubject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherSubjectDAO extends JpaRepository<TeacherSubject, Integer> {
}
