package bo.edu.ucb.backend.bl;

import bo.edu.ucb.backend.dao.QuestionDAO;
import bo.edu.ucb.backend.dao.UserDAO;
import bo.edu.ucb.backend.dto.QuestionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.edu.ucb.backend.dao.SubjectEnrollmentDAO;
import bo.edu.ucb.backend.dto.StudentSubjectsDTO;

@Service
public class StudentBL {
    private static final Logger LOG = LoggerFactory.getLogger(StudentBL.class);
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private QuestionDAO questionDAO;
    public Iterable<StudentSubjectsDTO> findMateriasAlumno(Integer userId) {
        try {
            LOG.info("Buscando las materias del alumno con id: {}", userId);
            return userDAO.getStudentSubjectsById(userId);
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se buscaba las materias del alumno: ", ex);
            throw new RuntimeException("Ocurrio un error mientras se buscaba las materias del alumno");
        }
    }

    public Iterable<QuestionDTO> findQuestions() {
        try {
            LOG.info("Buscando las preguntas de la evaluacion");
            return questionDAO.getQuestionsByTemplateEvaluation();
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se buscaba las preguntas de la evaluacion: ", ex);
            throw new RuntimeException("Ocurrio un error mientras se buscaba las preguntas de la evaluacion");
        }
    }

}
