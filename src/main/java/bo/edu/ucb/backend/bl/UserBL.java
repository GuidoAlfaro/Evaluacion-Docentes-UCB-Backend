package bo.edu.ucb.backend.bl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.edu.ucb.backend.dao.UserDAO;
import bo.edu.ucb.backend.entity.User;
@Service
public class UserBL {
    private static final Logger LOG = LoggerFactory.getLogger(UserBL.class);
    @Autowired
    private UserDAO userDAO;

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
}
