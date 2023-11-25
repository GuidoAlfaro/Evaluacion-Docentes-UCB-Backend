package bo.edu.ucb.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import bo.edu.ucb.backend.entity.SubjectEnrollment;

public interface SubjectEnrollmentDAO extends JpaRepository<SubjectEnrollment, Integer> {

}
