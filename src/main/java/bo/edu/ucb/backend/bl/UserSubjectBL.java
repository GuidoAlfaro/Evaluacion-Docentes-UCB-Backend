package bo.edu.ucb.backend.bl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.edu.ucb.backend.dao.SubjectEnrollmentDAO;
import bo.edu.ucb.backend.dto.StudentSubjectsDTO;
import bo.edu.ucb.backend.entity.SubjectEnrollment;

@Service
public class UserSubjectBL {
    private static final Logger LOG = LoggerFactory.getLogger(UserSubjectBL.class);
    @Autowired
    private SubjectEnrollmentDAO subjectEnrollmentDAO;

    public SubjectEnrollment findUserSubjectById(Integer userSubjectId) {
        try {
            LOG.info("Buscando el usuario materia con id: {}", userSubjectId);
            return subjectEnrollmentDAO.findById(userSubjectId).get();
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se buscaba el usuario materia: ", ex);
            throw new RuntimeException("Ocurrio un error mientras se buscaba el usuario materia");
        }
    }

    public Iterable<SubjectEnrollment> findAllUserSubjects() {
        try {
            LOG.info("Obteniendo todos los usuarios materias");
            return subjectEnrollmentDAO.findAll();
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se obtenia los usuarios materias: ", ex);
            throw new RuntimeException("Ocurrio un error mientras se obtenia los usuarios materias");
        }
    }

    public SubjectEnrollment createUserSubject(SubjectEnrollment userSubject) {
        try {
            LOG.info("Creando el usuario materia: {}", userSubject);
            return subjectEnrollmentDAO.save(userSubject);
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se creaba el usuario materia: ", ex);  
            throw new RuntimeException("Ocurrio un error mientras se creaba el usuario materia");
        }
    }

    public SubjectEnrollment updateUserSubject(SubjectEnrollment userSubject) {
        try {
            LOG.info("Actualizando el usuario materia: {}", userSubject);
            return subjectEnrollmentDAO.save(userSubject);
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se actualizaba el usuario materia: ", ex);
            return null;
        }
    }

//    public SubjectEnrollment updateUserSubjectById(Integer userSubjectId, SubjectEnrollment userSubject) {
//        try {
//            LOG.info("Actualizando el usuario materia con id: {}", userSubjectId);
//            SubjectEnrollment currentUserSubject = userSubjectDAO.findById(userSubjectId).get();
//            currentUserSubject.setStudentUserId(userSubject.getStudentUserId());
//            currentUserSubject.setTeacherUserId(userSubject.getTeacherUserId());
//            currentUserSubject.setSubjectId(userSubject.getSubjectId());
//            currentUserSubject.setSemester(userSubject.getSemester());
//            currentUserSubject.setYear(userSubject.getYear());
//            currentUserSubject.setParallel(userSubject.getParallel());
//            currentUserSubject.setEvaluated(userSubject.getEvaluated());
//            return userSubjectDAO.save(currentUserSubject);
//        } catch (Exception ex) {
//            LOG.error("Ocurrio un error mientras se actualizaba el usuario materia: ", ex);
//            return null;
//        }
//    }

    public void deleteUserSubjectById(Integer userSubjectId) {
        try {
            LOG.info("Eliminando el usuario materia con id: {}", userSubjectId);
            subjectEnrollmentDAO.deleteById(userSubjectId);
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se eliminaba el usuario materia: ", ex);
        }
    }

//    public Iterable<StudentSubjectsDTO> findMateriasAlumno(Integer userId) {
//        try {
//            LOG.info("Buscando las materias del alumno con id: {}", userId);
//            return subjectEnrollmentDAO.findSubjectsByStudentId(userId);
//        } catch (Exception ex) {
//            LOG.error("Ocurrio un error mientras se buscaba las materias del alumno: ", ex);
//            throw new RuntimeException("Ocurrio un error mientras se buscaba las materias del alumno");
//        }
//    }

}
