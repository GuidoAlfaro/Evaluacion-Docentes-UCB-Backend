package bo.edu.ucb.backend.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.edu.ucb.backend.bl.UserTypeBL;
import bo.edu.ucb.backend.dto.ResponseDTO;
import bo.edu.ucb.backend.entity.UserType;

@RestController
@RequestMapping(value = "api/v1/users/type")
public class UserTypeAPI {
    private static final Logger LOG = LoggerFactory.getLogger(UserTypeAPI.class);

    @Autowired
    private UserTypeBL userTypeBL;

    @GetMapping("/{id}")
    public ResponseDTO findUserTypeById(@PathVariable Integer id) {
        try {
            UserType userType = userTypeBL.findUserTypeById(id);
            if (userType != null) {
                return new ResponseDTO(userType);
            } else {
                return new ResponseDTO("400", "No existe el tipo de usuario con id: " + id);
            }
        } catch (Exception ex) {
            LOG.error("Error al encontrar el tipo de usuario: ", ex);
            return new ResponseDTO("400", "No existe el tipo de usuario con id: " + id);
        }
    }

    @GetMapping("/")
    public ResponseDTO findAllUserTypes() {
        try {
            return new ResponseDTO(userTypeBL.findAllUserTypes());
        } catch (Exception ex) {
            LOG.error("Error al encontrar los tipos de usuario: ", ex);
            return new ResponseDTO("400", "No existen tipos de usuario");
        }
    }

    @PostMapping("/")
    public ResponseDTO createUserType(@RequestBody UserType userType) {
        try {
            return new ResponseDTO(userTypeBL.createUserType(userType));
        } catch (Exception ex) {
            LOG.error("Error al crear el tipo de usuario: ", ex);
            return new ResponseDTO("400", "No se pudo crear el tipo de usuario");
        }
    }

    @PutMapping("/{id}/")
    public ResponseDTO updateUserType(@PathVariable Integer id, @RequestBody UserType userType) {
        try {
            UserType userTypeUpdated = userTypeBL.updateUserTypeById(id, userType);
            if (userTypeUpdated != null) {
                return new ResponseDTO(userTypeUpdated);
            } else {
                return new ResponseDTO("400", "No existe el tipo de usuario con id: " + id);
            }
        } catch (Exception ex) {
            LOG.error("Error al actualizar el tipo de usuario: ", ex);
            return new ResponseDTO("400", "No se pudo actualizar el tipo de usuario");
        }
    }

    @DeleteMapping("/{id}/")
    public ResponseDTO deleteUserType(@PathVariable Integer id) {
        try {
            userTypeBL.deleteUserType(id);
            return new ResponseDTO("Tipo de usuario eliminado correctamente");
        } catch (Exception ex) {
            LOG.error("Error al eliminar el tipo de usuario: ", ex);
            return new ResponseDTO("400", "No se pudo eliminar el tipo de usuario");
        }
    }    
}