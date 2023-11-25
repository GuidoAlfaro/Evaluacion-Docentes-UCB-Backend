package bo.edu.ucb.backend.api.endpoints_tables;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.edu.ucb.backend.bl.UserSubjectBL;
import bo.edu.ucb.backend.dto.ResponseDTO;
import bo.edu.ucb.backend.entity.SubjectEnrollment;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/users/subjects")
public class UserSubjectAPI {
    private static final Logger LOG = LoggerFactory.getLogger(UserSubjectAPI.class);
    @Autowired
    private UserSubjectBL userSubjectBL;

    @GetMapping("/")
    public ResponseDTO findAllUserSubjects() {
        try {
            return new ResponseDTO(userSubjectBL.findAllUserSubjects());
        } catch (Exception ex) {
            LOG.error("Error al encontrar los usuarios materias: ", ex);
            return new ResponseDTO("400", "No existen usuarios materias");
        }
    }

    @GetMapping("/{id}")
    public ResponseDTO findUserSubjectById(@PathVariable Integer id) {
        try {
            return new ResponseDTO(userSubjectBL.findUserSubjectById(id));
        } catch (Exception ex) {
            LOG.error("Error al encontrar el usuario materia: ", ex);
            return new ResponseDTO("400", "No existe el usuario materia con id: " + id);
        }
    }

    @PostMapping("/")
    public ResponseDTO createUserSubject(@RequestBody SubjectEnrollment userSubject) {
        try {
            return new ResponseDTO(userSubjectBL.createUserSubject(userSubject));
        } catch (Exception ex) {
            LOG.error("Error al crear el usuario materia: ", ex);
            return new ResponseDTO("400", "No se pudo crear el usuario materia");
        }
    }

//    @PutMapping("/{id}")
//    public ResponseDTO updateUserSubjectById(@PathVariable Integer id, @RequestBody SubjectEnrollment userSubject) {
//        try {
//            return new ResponseDTO(userSubjectBL.updateUserSubjectById(id, userSubject));
//        } catch (Exception ex) {
//            LOG.error("Error al actualizar el usuario materia: ", ex);
//            return new ResponseDTO("400", "No se pudo actualizar el usuario materia");
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseDTO deleteUserSubjectById(@PathVariable Integer id) {
//        try {
//            userSubjectBL.deleteUserSubjectById(id);
//            return new ResponseDTO("Usuario materia eliminado correctamente");
//        } catch (Exception ex) {
//            LOG.error("Error al eliminar el usuario materia: ", ex);
//            return new ResponseDTO("400", "No se pudo eliminar el usuario materia");
//        }
//    }
//    //FIXME: VERIFICA QUE EL ID NO SEA DE UN DOCENTE
//    //
//    @GetMapping("/teachers/{id}")
//    public ResponseDTO findUserSubjectByStudentId(@PathVariable Integer id) {
//        try {
//            return new ResponseDTO(userSubjectBL.findMateriasAlumno(id));
//        } catch (Exception ex) {
//            LOG.error("Error al encontrar el usuario materia: ", ex);
//            return new ResponseDTO("400", "No existe el usuario materia con id: " + id);
//        }
//    }
}
