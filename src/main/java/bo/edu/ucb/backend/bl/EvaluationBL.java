package bo.edu.ucb.backend.bl;

import bo.edu.ucb.backend.dao.EvaluationDAO;
import bo.edu.ucb.backend.entity.Evaluation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluationBL {
    private static final Logger LOG = LoggerFactory.getLogger(EvaluationBL.class);
    @Autowired
    private EvaluationDAO evaluationDAO;

    public Iterable<Evaluation> findAllEvaluations() {
        return evaluationDAO.findAll();
    }

    public Evaluation findEvaluationById(Integer evaluationId) {
        return evaluationDAO.findById(evaluationId).get();
    }

    public Evaluation createEvaluation(Evaluation evaluation) {
        return evaluationDAO.save(evaluation);
    }

    public Evaluation updateEvaluation(Evaluation evaluation) {
        return evaluationDAO.save(evaluation);
    }

    public Evaluation deleteEvaluation(Evaluation evaluation) {
        return evaluationDAO.save(evaluation);
    }

    public Evaluation findEvaluationByTemplate(Boolean template) {
        return evaluationDAO.findByTemplate(template);
    }
}
