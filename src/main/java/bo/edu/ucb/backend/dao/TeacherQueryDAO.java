package bo.edu.ucb.backend.dao;

import bo.edu.ucb.backend.entity.TeacherQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherQueryDAO extends JpaRepository<TeacherQuery, Integer> {
}
