package bo.edu.ucb.backend.dao;

import bo.edu.ucb.backend.entity.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationDAO extends JpaRepository<Evaluation, Integer> {
    Evaluation findByTemplate(Boolean template);
}
