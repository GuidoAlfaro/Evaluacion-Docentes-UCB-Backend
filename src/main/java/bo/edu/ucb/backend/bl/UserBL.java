package bo.edu.ucb.backend.bl;

import bo.edu.ucb.backend.dto.*;
import bo.edu.ucb.backend.entity.UserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.edu.ucb.backend.dao.UserDAO;
import bo.edu.ucb.backend.entity.User;

import java.util.List;

@Service
public class UserBL {
    private static final Logger LOG = LoggerFactory.getLogger(UserBL.class);
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private UserTypeBL userTypeBL;

    public User findUserById(Integer userId) {
        try {
            LOG.info("Buscando el usuario con id: {}", userId);
            return userDAO.findById(userId).orElse(null);
            // Usar "orElse(null)" para evitar una excepción si el usuario no se encuentra
        } catch (Exception ex) {
            LOG.error("Ocurrió un error mientras se buscaba el usuario: ", ex);
            throw new RuntimeException("Ocurrió un error mientras se buscaba el usuario");
        }
    }

    public Iterable<User> findAllUsers() {
        try {
            LOG.info("Obteniendo todos los usuarios");
            return userDAO.findAll();
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se obtenia los usuarios: ", ex);
            throw new RuntimeException("Ocurrio un error mientras se obtenia los usuarios");
        }
    }

    public User createUser(User user) {
        try {
            LOG.info("Creando el usuario: {}", user);
            return userDAO.save(user);
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se creaba el usuario: ", ex);  
            throw new RuntimeException("Ocurrio un error mientras se creaba el usuario");
        }
    }

    public User updateUser(User user) {
        try {
            LOG.info("Actualizando el usuario: {}", user);
            return userDAO.save(user);
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se actualizaba el usuario: ", ex);
            return null;
        }
    }

    public User updateUserById(Integer userId, User user) {
        try {
            LOG.info("Actualizando el usuario con id: {}", userId);
            User currentUser = userDAO.findById(userId).get();
            currentUser.setFirstNames(user.getFirstNames());
            currentUser.setLastNames(user.getLastNames());
            currentUser.setEmail(user.getEmail());
            currentUser.setUserType(user.getUserType());
            return userDAO.save(currentUser);
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se actualizaba el usuario: ", ex);
            return null;
        }
    }

    public void deleteUserById(Integer userId) {
        try {
            LOG.info("Eliminando el usuario con id: {}", userId);
            userDAO.deleteById(userId);
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se eliminaba el usuario: ", ex);
        }
    }

    public User verifyUserbyEmail(String email) {
        try {
            LOG.info("Verificando usuario con correo: {}", email);
            User user = userDAO.findByEmail(email);
            if(user == null) {
                throw new RuntimeException("No existe el usuario con correo: " + email);
            }
            return user;
        } catch (Exception e) {
           LOG.error("Ocurrio un error", e);
           throw new RuntimeException("No existe el usuario con correo: " + email);
        }
    }

    //FIXME: ESTO SIENTO QUE NO DEBERIA ESTAR AQUI, TODAS LAS FUNCIONES HACIA ABAJO
    // IMPORTANTES
    public Iterable<StudentSubjectsDTO> findMateriasAlumno(Integer userId) {
        try {
            LOG.info("Buscando las materias del alumno con id: {}", userId);
            return userDAO.getStudentSubjectsById(userId);
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se buscaba las materias del alumno: ", ex);
            throw new RuntimeException("Ocurrio un error mientras se buscaba las materias del alumno");
        }
    }

    public Iterable<TeacherSubjectsDTO> findMateriasDocente(Integer userId) {
        try {
            LOG.info("Buscando las materias del docente con id: {}", userId);
            List<TeacherSubjectsDTO> teacherSubjectsDTOList = userDAO.getTeacherSubjects(userId);
            for (TeacherSubjectsDTO teacherSubjectsDTO : teacherSubjectsDTOList) {
                String cleanedInput = teacherSubjectsDTO.getEvaluationPercent().replaceAll("[%\\s]", "");

                // Convertir a un número decimal
                double number = Double.parseDouble(cleanedInput);

                // Formatear a dos decimales
                String formattedNumber = String.format("%.2f", number);
                teacherSubjectsDTO.setEvaluationPercent(formattedNumber+ "%" );
            }
            return teacherSubjectsDTOList;
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se buscaba las materias del docente: ", ex);
            throw new RuntimeException("Ocurrio un error mientras se buscaba las materias del docente");
        }
    }

    public List<EvaluationDetailDTO> findTeacherSubjectDetails(Integer teacherSubjectId) {
        try {
            LOG.info("Buscando los detalles de la materia con id: {}", teacherSubjectId);
            return userDAO.getEvaluationDetail(teacherSubjectId);
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se buscaba los detalles de la materia: ", ex);
            throw new RuntimeException("Ocurrio un error mientras se buscaba los detalles de la materia");
        }
    }

    public UserTypeDTO login(String email) {
        try {
            LOG.info("Determinando el tipo de usuario con correo: {}", email);
            return userTypeBL.userTypeByEmail(email);
        } catch (Exception e) {
           LOG.error("Ocurrio un error", e);
           throw new RuntimeException("No existe el usuario con correo: " + email);
        }
    }
}
