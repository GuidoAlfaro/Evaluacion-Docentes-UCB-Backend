package bo.edu.ucb.backend.api;

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

import bo.edu.ucb.backend.bl.SubjectBL;
import bo.edu.ucb.backend.dto.ResponseDTO;
import bo.edu.ucb.backend.entity.Subject;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/subjects")
public class SubjectAPI {
    private static final Logger LOG = LoggerFactory.getLogger(SubjectAPI.class);
    @Autowired
    private SubjectBL subjectBL;

    @GetMapping("/")
    public ResponseDTO findAllSubjects() {
        try {
            return new ResponseDTO(subjectBL.findAllSubjects());
        } catch (Exception ex) {
            LOG.error("Error al encontrar las materias: ", ex);
            return new ResponseDTO("400", "No existen materias");
        }
    }

    @GetMapping("/{id}")
    public ResponseDTO findSubjectById(Integer id) {
        try {
            return new ResponseDTO(subjectBL.findSubjectById(id));
        } catch (Exception ex) {
            LOG.error("Error al encontrar la materia: ", ex);
            return new ResponseDTO("400", "No existe la materia con id: " + id);
        }
    }

    @PostMapping("/")
    public ResponseDTO createSubject(@RequestBody Subject subject) {
        try {
            return new ResponseDTO(subjectBL.createSubject(subject));
        } catch (Exception ex) {
            LOG.error("Error al crear la materia: ", ex);
            return new ResponseDTO("400", "No se pudo crear la materia");
        }
    }

    @PutMapping("/{id}")
    public ResponseDTO updateSubjectById(@PathVariable Integer id, @RequestBody Subject subject) {
        try {
            return new ResponseDTO(subjectBL.updateSubjectById(id, subject));
        } catch (Exception ex) {
            LOG.error("Error al actualizar la materia: ", ex);
            return new ResponseDTO("400", "No se pudo actualizar la materia");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseDTO deleteSubjectById(@PathVariable Integer id) {
        try {
            subjectBL.deleteSubjectById(id);
            return new ResponseDTO("Materia eliminada");
        } catch (Exception ex) {
            LOG.error("Error al eliminar la materia: ", ex);
            return new ResponseDTO("400", "No se pudo eliminar la materia");
        }
    }
}
