package bo.edu.ucb.backend.bl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.edu.ucb.backend.dao.UserSubjectDAO;
import bo.edu.ucb.backend.entity.UserSubject;

@Service
public class UserSubjectBL {
    private static final Logger LOG = LoggerFactory.getLogger(UserSubjectBL.class);
    @Autowired
    private UserSubjectDAO userSubjectDAO;

    public UserSubject findUserSubjectById(Integer userSubjectId) {
        try {
            LOG.info("Buscando el usuario materia con id: {}", userSubjectId);
            return userSubjectDAO.findById(userSubjectId).get();
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se buscaba el usuario materia: ", ex);
            throw new RuntimeException("Ocurrio un error mientras se buscaba el usuario materia");
        }
    }

    public Iterable<UserSubject> findAllUserSubjects() {
        try {
            LOG.info("Obteniendo todos los usuarios materias");
            return userSubjectDAO.findAll();
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se obtenia los usuarios materias: ", ex);
            throw new RuntimeException("Ocurrio un error mientras se obtenia los usuarios materias");
        }
    }

    public UserSubject createUserSubject(UserSubject userSubject) {
        try {
            LOG.info("Creando el usuario materia: {}", userSubject);
            return userSubjectDAO.save(userSubject);
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se creaba el usuario materia: ", ex);  
            throw new RuntimeException("Ocurrio un error mientras se creaba el usuario materia");
        }
    }

    public UserSubject updateUserSubject(UserSubject userSubject) {
        try {
            LOG.info("Actualizando el usuario materia: {}", userSubject);
            return userSubjectDAO.save(userSubject);
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se actualizaba el usuario materia: ", ex);
            return null;
        }
    }

    public UserSubject updateUserSubjectById(Integer userSubjectId, UserSubject userSubject) {
        try {
            LOG.info("Actualizando el usuario materia con id: {}", userSubjectId);
            UserSubject currentUserSubject = userSubjectDAO.findById(userSubjectId).get();
            currentUserSubject.setStudentUserId(userSubject.getStudentUserId());
            currentUserSubject.setTeacherUserId(userSubject.getTeacherUserId());
            currentUserSubject.setSubjectId(userSubject.getSubjectId());
            currentUserSubject.setSemester(userSubject.getSemester());
            currentUserSubject.setYear(userSubject.getYear());
            currentUserSubject.setParallel(userSubject.getParallel());
            currentUserSubject.setEvaluated(userSubject.getEvaluated());
            return userSubjectDAO.save(currentUserSubject);
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se actualizaba el usuario materia: ", ex);
            return null;
        }
    }

    public void deleteUserSubjectById(Integer userSubjectId) {
        try {
            LOG.info("Eliminando el usuario materia con id: {}", userSubjectId);
            userSubjectDAO.deleteById(userSubjectId);
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se eliminaba el usuario materia: ", ex);
        }
    }

}
