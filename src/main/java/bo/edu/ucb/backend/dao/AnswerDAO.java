package bo.edu.ucb.backend.dao;

import bo.edu.ucb.backend.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerDAO extends JpaRepository<Answer, Integer> {
}
