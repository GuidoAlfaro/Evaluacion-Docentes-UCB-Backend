package bo.edu.ucb.backend.dao;

import bo.edu.ucb.backend.entity.SubjectEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectEvaluationDAO extends JpaRepository<SubjectEvaluation, Integer> {
}
