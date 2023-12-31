package bo.edu.ucb.backend.dao;

import bo.edu.ucb.backend.entity.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParameterDAO extends JpaRepository<Parameter, Integer> {

    @Query("SELECT p.parameterId FROM Parameter p WHERE EXISTS " +
            "(SELECT 1 FROM Question q WHERE q.parameter = p AND q.evaluation.template = true)")
    List<String> findParametersUsedInCurrentEvaluation();


    @Query("SELECT q.questionText, a.answerText " +
            "FROM Question q " +
            "JOIN Answer a ON a.question = q " +
            "WHERE q.parameter.parameterId = :paramId " +
            "AND a.subjectEvaluation.subjectEvaluationId = :subjectEvaluationId")
    List<Object[]> findQuestionsAndAnswersByParameterAndEvaluation(
            @Param("paramId") String paramId,
            @Param("subjectEvaluationId") Integer subjectEvaluationId);
}
