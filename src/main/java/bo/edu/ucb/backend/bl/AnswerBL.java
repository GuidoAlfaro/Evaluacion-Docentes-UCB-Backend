package bo.edu.ucb.backend.bl;

import bo.edu.ucb.backend.dao.AnswerDAO;
import bo.edu.ucb.backend.entity.Answer;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerBL {
    private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(AnswerBL.class);
    @Autowired
    private AnswerDAO answerDAO;



    @Transactional
    public void saveAnswer(List<Answer> answers) {
        try {
            //FIXME: Luego quitas esto
            for (Answer answer : answers) {
                answer.setTxUser("guidoalfaro");
                answer.setTxHost("192.168.10.0");
                LOG.info("respuesta {}",answer.toString());
            }
            LOG.info("Respondiendo la evaluacion");
            answerDAO.saveAll(answers);
            LOG.info("Respuestas guardadas");
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se guardaba la respuesta: ", ex);
            throw new RuntimeException("Ocurrio un error mientras se guardaba la respuesta");
        }
    }

    @Transactional
    public void deleteAnswer(List<Answer> answers) {
        try {
            LOG.info("Borrando las respuestas");
            answerDAO.deleteAll(answers);
            LOG.info("Respuestas borradas");
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se borraban las respuestas: ", ex);
            throw new RuntimeException("Ocurrio un error mientras se borraban las respuestas");
        }
    }
}
