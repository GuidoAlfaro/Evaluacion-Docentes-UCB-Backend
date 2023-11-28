package bo.edu.ucb.backend.bl;

import bo.edu.ucb.backend.dao.QuestionDAO;
import bo.edu.ucb.backend.dto.QuestionDTO;
import bo.edu.ucb.backend.entity.Evaluation;
import bo.edu.ucb.backend.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminBL {
    @Autowired
    private QuestionDAO questionDAO;
    @Autowired
    private EvaluationBL evaluationBL;
    public List<QuestionDTO> createQuestion(List<QuestionDTO> questions) {
        Evaluation evaluation = evaluationBL.findEvaluationByTemplate(true);
        for (QuestionDTO question : questions) {
            Question newQuestion = new Question();
            newQuestion.setQuestionText(question.getQuestionText());
            newQuestion.setEvaluation(evaluation);
            newQuestion.setStatus((short) 1);
            questionDAO.save(newQuestion);
        }
        return questions;
    }
}
