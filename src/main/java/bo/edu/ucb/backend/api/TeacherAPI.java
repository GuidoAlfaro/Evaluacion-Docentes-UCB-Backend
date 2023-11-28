package bo.edu.ucb.backend.api;

import bo.edu.ucb.backend.bl.TeacherBL;
import bo.edu.ucb.backend.dto.ResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class TeacherAPI {
    private static final Logger LOG = LoggerFactory.getLogger(TeacherAPI.class);
    @Autowired
    private TeacherBL teacherBL;

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
}
