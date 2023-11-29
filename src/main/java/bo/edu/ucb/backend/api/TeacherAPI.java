package bo.edu.ucb.backend.api;

import bo.edu.ucb.backend.bl.ParameterBL;
import bo.edu.ucb.backend.bl.TeacherBL;
import bo.edu.ucb.backend.dto.ParameterDTO;
import bo.edu.ucb.backend.dto.ResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TeacherAPI {
    private static final Logger LOG = LoggerFactory.getLogger(TeacherAPI.class);
    @Autowired
    private TeacherBL teacherBL;
    @Autowired
    private ParameterBL parameterBL;
    @GetMapping("api/v1/subjects/{id}")
    public ResponseDTO findTeacherSubjects(@PathVariable Integer id) {
        try {
            LOG.info("Buscando las materias del docente con id: {}", id);
            return new ResponseDTO(teacherBL.findTeacherSubjects(id));//FIXME: Que verifique si el teacher existe para asi botar error, eso falta
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se buscaba las materias del docente: ", ex);
            return new ResponseDTO("400", "Ocurrio un error mientras se buscaba las materias del docente");
        }
    }

    @GetMapping("api/v1/subjects/{id}/generate")
    public ResponseDTO generateDetails(@PathVariable Integer id) {
        try {
            LOG.info("Generando detalles de la evaluacion del docente, de la materia con id {}", id);
            List<ParameterDTO> parameterDTOList = parameterBL.findParametersAndQuestionsWithAnswers(id);
            return new ResponseDTO(teacherBL.fetchAnswers(parameterDTOList));
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se generaba el detalle: ", ex);
            return new ResponseDTO("400", "Ocurrio un error mientras se generaba el detalle");
        }
    }

//    @GetMapping("api/v1/parameters")
//    public ResponseDTO findParametersUsedInCurrentEvaluation() {
//        try {
//            LOG.info("Buscando los parametros usados en la evaluacion actual");
////            return new ResponseDTO(parameterBL.findParametersAndQuestionsWithAnswers());
//            ResponseDTO responseDTO = new ResponseDTO(parameterBL.findParametersAndQuestionsWithAnswers(3));
//            teacherBL.fetchAnswers(responseDTO.getData());
//            return responseDTO;
//        } catch (Exception ex) {
//            LOG.error("Ocurrio un error mientras se buscaba los parametros usados en la evaluacion actual: ", ex);
//            return new ResponseDTO("400", "Ocurrio un error mientras se buscaba los parametros usados en la evaluacion actual");
//        }
//    }
}