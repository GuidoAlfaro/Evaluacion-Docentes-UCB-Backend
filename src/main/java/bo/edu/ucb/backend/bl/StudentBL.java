package bo.edu.ucb.backend.bl;

import bo.edu.ucb.backend.dao.AnswerDAO;
import bo.edu.ucb.backend.dao.QuestionDAO;
import bo.edu.ucb.backend.dao.UserDAO;
import bo.edu.ucb.backend.dto.QuestionDTO;
import bo.edu.ucb.backend.entity.Answer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.edu.ucb.backend.dao.SubjectEnrollmentDAO;
import bo.edu.ucb.backend.dto.StudentSubjectsDTO;

import java.util.List;

@Service
public class StudentBL {
    private static final Logger LOG = LoggerFactory.getLogger(StudentBL.class);
    @Autowired
    SubjectEnrollmentBL subjectEnrollmentBL;
    @Autowired
    private UserBL userBL;
    @Autowired
    private QuestionBL questionBL;
    @Autowired
    private AnswerBL answerBL;
    public Iterable<StudentSubjectsDTO> findMateriasAlumno(Integer userId) {
        try {
            LOG.info("Buscando las materias del alumno con id: {}", userId);
            return userBL.findMateriasAlumno(userId);
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se buscaba las materias del alumno: ", ex);
            throw new RuntimeException("Ocurrio un error mientras se buscaba las materias del alumno");
        }
    }

    public Iterable<QuestionDTO> findQuestions() {
        try {
            LOG.info("Buscando las preguntas de la evaluacion");
            return questionBL.findQuestions();
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se buscaba las preguntas de la evaluacion: ", ex);
            throw new RuntimeException("Ocurrio un error mientras se buscaba las preguntas de la evaluacion");
        }
    }

    public void answerEvaluation(List<Answer> answers) {
        try {
            answerBL.saveAnswer(answers);
            try {
            subjectEnrollmentBL.updateEvaluatedStatus(answers.get(0).getSubjectEvaluation().getSubjectEvaluationId(), answers.get(0).getStudent().getUserId());
            LOG.info("Estado de evaluacion actualizado");
            } catch (Exception ex) {
                LOG.error("Ocurrio un error mientras se actualizaba el estado de la evaluacion: ", ex);
                // borrar las respuestas por seguridad en caso de que no se actualice el estado de la evaluacion
                answerBL.deleteAnswer(answers);
                throw new RuntimeException("Ocurrio un error mientras se actualizaba el estado de la evaluacion");
            }
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se respondia la evaluacion: ", ex);
            throw new RuntimeException("Ocurrio un error mientras se respondia la evaluacion");
        }
    }
}