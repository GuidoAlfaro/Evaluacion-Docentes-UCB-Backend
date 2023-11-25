package bo.edu.ucb.backend.api;

import bo.edu.ucb.backend.dto.QuestionDTO;
import bo.edu.ucb.backend.dto.ResponseDTO;
import bo.edu.ucb.backend.entity.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import bo.edu.ucb.backend.bl.AdminBL;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class AdminAPI {
    private static final Logger LOG = LoggerFactory.getLogger(AdminAPI.class);

    @Autowired
    private AdminBL adminBL;

    @PostMapping(path = "api/v1/evaluations")
    public ResponseDTO createQuestions(@RequestBody List<QuestionDTO> questions) {
        try {
            LOG.info("creando preguntas: {}", questions);
            return new ResponseDTO(adminBL.createQuestion(questions));
        } catch (Exception ex) {
            LOG.error("Error al crear las preguntas: ", ex);
            return new ResponseDTO("400", "No se pudo crear las preguntas");
        }
    }
}
