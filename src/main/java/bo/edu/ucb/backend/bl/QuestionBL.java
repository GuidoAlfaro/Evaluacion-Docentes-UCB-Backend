package bo.edu.ucb.backend.bl;

import bo.edu.ucb.backend.dao.QuestionDAO;
import bo.edu.ucb.backend.entity.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionBL {
    private static final Logger LOG = LoggerFactory.getLogger(QuestionBL.class);
    @Autowired
    private QuestionDAO questionDAO;

    public Question createQuestion(Question question) {
        try {
            return questionDAO.save(question);
        } catch (Exception ex) {
            LOG.error("Ocurrio un error creando la pregunta: "+ question.getQuestionText(), ex);
            throw ex;
        }
    }

    public Question updateQuestion(Question question) {
        try {
            return questionDAO.save(question);
        } catch (Exception ex) {
            LOG.error("Ocurrio un error actualizando la pregunta: "+ question.getQuestionText(), ex);
            throw ex;
        }
    }

    public Question findQuestionById(Integer questionId) {
        try {
            return questionDAO.findById(questionId).get();
        } catch (Exception ex) {
            LOG.error("Ocurrio un error leyendo la pregunta con id: "+ questionId, ex);
            throw ex;
        }
    }

    public void deleteQuestion(Integer questionId) {
        try {
            questionDAO.deleteById(questionId);
        } catch (Exception ex) {
            LOG.error("Ocurrio un error eliminando la pregunta con id: "+ questionId, ex);
            throw ex;
        }
    }

    public Iterable<Question> findAllQuestions() {
        try {
            return questionDAO.findAll();
        } catch (Exception ex) {
            LOG.error("Ocurrio un error leyendo las preguntas", ex);
            throw ex;
        }
    }
}
