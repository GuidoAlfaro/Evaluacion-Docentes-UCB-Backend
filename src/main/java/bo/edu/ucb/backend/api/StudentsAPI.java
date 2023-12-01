package bo.edu.ucb.backend.api;

import bo.edu.ucb.backend.bl.QuestionBL;
import bo.edu.ucb.backend.dto.QuestionDTO;
import bo.edu.ucb.backend.dto.ResponseDTO;
import bo.edu.ucb.backend.entity.Answer;
import bo.edu.ucb.backend.entity.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import bo.edu.ucb.backend.bl.StudentBL;
import bo.edu.ucb.backend.dto.StudentSubjectsDTO;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class StudentsAPI {
    private static final Logger LOG = LoggerFactory.getLogger(StudentsAPI.class); 
    @Autowired
    private StudentBL studentBL;

    @GetMapping(path = "api/v1/teachers/{id}")
    public ResponseDTO findMateriasAlumno(@PathVariable Integer id) {
        try {
            LOG.info("Buscando las materias del alumno con id: {}", id);
            return new ResponseDTO(studentBL.findMateriasAlumno(id));
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se buscaba las materias del alumno: ", ex);
            return new ResponseDTO("400", "Ocurrio un error mientras se buscaba las materias del alumno");
        }
    }

    @GetMapping(path = "api/v1/evaluations/questions")
    public ResponseDTO findCurrentEvaluationQuestions() {

        try {
            LOG.info("Buscando las preguntas de la evaluacion");
            return new ResponseDTO(studentBL.findQuestions());
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se buscaba las preguntas de la evaluacion: ", ex);
            return new ResponseDTO("400", "Ocurrio un error mientras se buscaba las preguntas de la evaluacion");
        }
    }

    @PostMapping(path = "api/v1/teachers")
    public ResponseDTO answerEvaluation(@RequestBody List<Answer> answers) {
        try {
            LOG.info("Respondiendo la evaluacion");
            studentBL.answerEvaluation(answers);
            return new ResponseDTO("Se respondio la evaluacion exitosamente");
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se respondia la evaluacion: ", ex);
            return new ResponseDTO("400", "Ocurrio un error mientras se respondia la evaluacion");
        }
    }
}