package bo.edu.ucb.backend.bl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.edu.ucb.backend.dao.SubjectDAO;
import bo.edu.ucb.backend.entity.Subject;

@Service
public class SubjectBL {
    private static final Logger LOG = LoggerFactory.getLogger(SubjectBL.class);
    @Autowired
    private SubjectDAO subjectDAO;
    
    public Subject findSubjectById(Integer subjectId) {
        try {
            LOG.info("Buscando la materia con id: {}", subjectId);
            return subjectDAO.findById(subjectId).get();
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se buscaba la materia: ", ex);
            throw new RuntimeException("Ocurrio un error mientras se buscaba la materia");
        }
    }

    public Iterable<Subject> findAllSubjects() {
        try {
            LOG.info("Obteniendo todas las materias");
            return subjectDAO.findAll();
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se obtenia las materias: ", ex);
            throw new RuntimeException("Ocurrio un error mientras se obtenia las materias");
        }
    }

    public Subject createSubject(Subject subject) {
        try {
            LOG.info("Creando la materia: {}", subject);
            return subjectDAO.save(subject);
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se creaba la materia: ", ex);  
            throw new RuntimeException("Ocurrio un error mientras se creaba la materia");
        }
    }

    public Subject updateSubject(Subject subject) {
        try {
            LOG.info("Actualizando la materia: {}", subject);
            return subjectDAO.save(subject);
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se actualizaba la materia: ", ex);
            return null;
        }
    }

    public Subject updateSubjectById(Integer subjectId, Subject subject) {
        try {
            LOG.info("Actualizando la materia con id: {}", subjectId);
            Subject currentSubject = subjectDAO.findById(subjectId).get();
            currentSubject.setName(subject.getName());
            return subjectDAO.save(currentSubject);
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se actualizaba la materia: ", ex);
            return null;
        }
    }

    public void deleteSubjectById(Integer subjectId) {
        try {
            LOG.info("Eliminando la materia con id: {}", subjectId);
            subjectDAO.deleteById(subjectId);
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se eliminaba la materia: ", ex);
        }
    }
}
