package bo.edu.ucb.backend.dao;

import bo.edu.ucb.backend.dto.QuestionDTO;
import bo.edu.ucb.backend.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionDAO extends JpaRepository<Question, Integer> {
    @Query("SELECT new bo.edu.ucb.backend.dto.QuestionDTO(q.questionId, q.questionText) " +
            "FROM Question q " +
            "WHERE q.evaluation.template = true AND q.status = 1")
    List<QuestionDTO> getQuestionsByTemplateEvaluation();
}
