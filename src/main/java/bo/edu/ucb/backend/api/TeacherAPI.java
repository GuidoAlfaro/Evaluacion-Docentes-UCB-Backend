package bo.edu.ucb.backend.api;

import bo.edu.ucb.backend.bl.ParameterBL;
import bo.edu.ucb.backend.bl.TeacherBL;
import bo.edu.ucb.backend.bl.TeacherSubjectBL;
import bo.edu.ucb.backend.dto.ChatRequest;
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
    @Autowired
    private TeacherSubjectBL teacherSubjectBL;

    //FIXME: LA RUTA NO ES MUY RESTFUL
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

//    @GetMapping("api/v1/subjects/{id}/details")
//    public ResponseDTO findTeacherSubjectDetails(@PathVariable Integer id) {
//        try {
//            LOG.info("Buscando los detalles de la materia con id: {}", id);
//            return new ResponseDTO(teacherBL.findTeacherSubjectDetails(id));
//        } catch (Exception ex) {
//            LOG.error("Ocurrio un error mientras se buscaba los detalles de la materia: ", ex);
//            return new ResponseDTO("400", "Ocurrio un error mientras se buscaba los detalles de la materia");
//        }
//    }


    @PostMapping("api/v1/subjects/{id}/generate")
    public ResponseDTO generateDetails(@PathVariable Integer id) {
        try {
            LOG.info("Generando detalles de la evaluacion del docente, de la materia con id {}", id);
            Integer subjectEvaluationId = teacherSubjectBL.findSubjectEvaluationByTeacherSubjectId(id);

            LOG.info("El id de la evaluacion de la materia es: {}", subjectEvaluationId);

            List<ParameterDTO> parameterDTOList = parameterBL.findParametersAndQuestionsWithAnswers(subjectEvaluationId);
            LOG.info("Se encontraron {} parametros", parameterDTOList.size());
            teacherBL.generateSubjectResults(parameterDTOList, id);
            return new ResponseDTO("Se generaron los detalles de la evaluacion del docente");
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se generaba el detalle: ", ex);
            return new ResponseDTO("400", "Ocurrio un error mientras se generaba el detalle");
        }
    }

    @GetMapping("api/v1/subjects/{id}/details")
    public ResponseDTO findSubjectDetail(@PathVariable Integer id) {
        try {
            LOG.info("Buscando las materias del docente con id: {}", id);
            return new ResponseDTO(teacherBL.findTeacherSubjectDetails(id));
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se buscaba las materias del docente: ", ex);
            return new ResponseDTO("400", "Ocurrio un error mientras se buscaba las materias del docente");
        }
    }

    @PostMapping("api/v1/subjects/{id}/queries")
    public ResponseDTO teacherPrompt(@RequestBody ChatRequest chatRequest, @PathVariable Integer id) {
        try {
            LOG.info("Buscando las consultas de los docentes");
            return new ResponseDTO(teacherBL.generateTeacherQuery(chatRequest, id));
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se buscaba las consultas de los docentes: ", ex);
            return new ResponseDTO("400", "Ocurrio un error mientras se realizaba las consultas de los docentes");
        }
    }

    @GetMapping("api/v1/subjects/{id}/queries")
    public ResponseDTO findTeacherQueriesForSubject(@PathVariable Integer id) {
        try {
            LOG.info("Buscando las consultas de los docentes");
            return new ResponseDTO(teacherBL.findAllTeacherQueries(id));
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se buscaba las consultas de los docentes: ", ex);
            return new ResponseDTO("400", "Ocurrio un error mientras se realizaba las consultas de los docentes");
        }
    }

    @PatchMapping("api/v1/subjects/queries/{id}")
    public ResponseDTO updateTeacherQuery(@PathVariable Integer id) {
        try {
            LOG.info("Actualizando la consulta del docente");
            return new ResponseDTO(teacherBL.updateTeacherQuery(id));
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se actualizaba la consulta del docente: ", ex);
            return new ResponseDTO("400", "Ocurrio un error mientras se actualizaba la consulta del docente");
        }
    }

//    @PostMapping("api/v1/ranking")
//    public ResponseDTO createSubjectResult(@RequestBody Integer teacherSubjectId) {
//        try {
//            LOG.info("Creando el resultado de la materia");
//            return new ResponseDTO(teacherBL.saveSubjectResults(teacherSubjectId));
//        } catch (Exception ex) {
//            LOG.error("Ocurrio un error mientras se creaba el resultado de la materia: ", ex);
//            return new ResponseDTO("400", "Ocurrio un error mientras se creaba el resultado de la materia");
//        }
//    }
    @GetMapping("api/v1/ranking")
    public ResponseDTO findRanking() {
        try {
            LOG.info("Obteniendo ranking de docentes");
            return new ResponseDTO(teacherBL.findRanking());
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se obtenia el ranking: ", ex);
            return new ResponseDTO("400", "Ocurrio un error mientras se obtenia el ranking");
        }
    }
}