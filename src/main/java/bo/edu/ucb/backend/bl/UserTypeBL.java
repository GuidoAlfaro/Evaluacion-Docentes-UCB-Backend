package bo.edu.ucb.backend.bl;

import bo.edu.ucb.backend.dto.UserTypeDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.edu.ucb.backend.dao.UserTypeDAO;
import bo.edu.ucb.backend.entity.UserType;

@Service
public class UserTypeBL {
    @Autowired
    private UserTypeDAO userTypeDAO;

    private static final Logger LOG = LoggerFactory.getLogger(UserTypeBL.class);
    
    public UserType findUserTypeById(Integer userTypeId) {
        try {
            LOG.info("Buscando el tipo de usuario con id: {}", userTypeId);
            return userTypeDAO.findById(userTypeId).get();
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se buscaba el tipo de usuario: ", ex);
            throw new RuntimeException("Ocurrio un error mientras se buscaba el tipo de usuario");
        }
    }

    public Iterable<UserType> findAllUserTypes() {
        try {
            LOG.info("Obteniendo todos los tipos de usuario");
            return userTypeDAO.findAll();
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se obtenia los tipos de usuario: ", ex);
            throw new RuntimeException("Ocurrio un error mientras se obtenia los tipos de usuario");
        }
    }

    public UserType createUserType(UserType userType) {
        try {
            LOG.info("Creando el tipo de usuario: {}", userType);
            return userTypeDAO.save(userType);
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se creaba el tipo de usuario: ", ex);  
            throw new RuntimeException("Ocurrio un error mientras se creaba el tipo de usuario");
        }
    }

    public UserType updateUserType(UserType userType) {
        try {
            LOG.info("Actualizando el tipo de usuario: {}", userType);
            return userTypeDAO.save(userType);
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se actualizaba el tipo de usuario: ", ex);
            return null;
        }
    }

    public UserType updateUserTypeById(Integer userTypeId, UserType userType) {
        try {
            LOG.info("Actualizando el tipo de usuario con id: {}", userTypeId);
            UserType userTypeOld = userTypeDAO.findById(userTypeId).get();
            userTypeOld.setDescription(userType.getDescription());
            return userTypeDAO.save(userTypeOld);
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se actualizaba el tipo de usuario: ", ex);
            return null;
        }
    }

    public void deleteUserType(Integer userTypeId) {
        try {
            LOG.info("Eliminando el tipo de usuario con id: {}", userTypeId);
            userTypeDAO.deleteById(userTypeId);
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se eliminaba el tipo de usuario: ", ex);
        }
    }

    public UserTypeDTO userTypeByEmail(String email) {
        try {
            LOG.info("Buscando el tipo de usuario con email: {}", email);
            UserTypeDTO userType =  userTypeDAO.findUserTypeById(email);
            if (userType != null) {
                return userType;
            } else {
                LOG.error("No existe el tipo de usuario con email: {}", email);
                throw new RuntimeException("Usuario inexistente");
            }
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se buscaba el tipo de usuario: ", ex);
            throw new RuntimeException("Ocurrio un error: ", ex);
        }
    }
}
