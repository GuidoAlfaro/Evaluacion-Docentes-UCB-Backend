package bo.edu.ucb.backend.api;

import bo.edu.ucb.backend.bl.QuestionBL;
import bo.edu.ucb.backend.dto.QuestionDTO;
import bo.edu.ucb.backend.entity.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import bo.edu.ucb.backend.bl.StudentBL;
import bo.edu.ucb.backend.dto.StudentSubjectsDTO;

@RestController
@CrossOrigin(origins = "*")
public class StudentsAPI {
    private static final Logger LOG = LoggerFactory.getLogger(StudentsAPI.class); 
    @Autowired
    private StudentBL studentBL;

    @GetMapping(path = "api/v1/teachers/{id}")
    public Iterable<StudentSubjectsDTO> findMateriasAlumno(@PathVariable Integer id) {
        return studentBL.findMateriasAlumno(id);
    }

    @GetMapping(path = "api/v1/evaluations/questions/")
    public Iterable<QuestionDTO> findCurrentEvaluationQuestions() {
        return studentBL.findQuestions();
    }
}