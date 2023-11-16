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

import bo.edu.ucb.backend.bl.UserBL;
import bo.edu.ucb.backend.dto.LoginDTO;
import bo.edu.ucb.backend.dto.ResponseDTO;
import bo.edu.ucb.backend.entity.User;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "api/v1/users")
public class UserAPI {
    private static final Logger LOG = LoggerFactory.getLogger(UserAPI.class);
    @Autowired
    private UserBL userBL;

    @GetMapping("/")
    public ResponseDTO findAllUsers() {
        try {
            return new ResponseDTO(userBL.findAllUsers());
        } catch (Exception ex) {
            LOG.error("Error al encontrar los usuarios: ", ex);
            return new ResponseDTO("400", "No existen usuarios");
        }
    }

    @GetMapping("/{id}")
    public ResponseDTO findUserById(@PathVariable Integer id) {
        try {
            return new ResponseDTO(userBL.findUserById(id));
        } catch (Exception ex) {
            LOG.error("Error al encontrar el usuario: ", ex);
            return new ResponseDTO("400", "No existe el usuario con id: " + id);
        }
    }

    @PostMapping("/")
    public ResponseDTO createUser(@RequestBody User user) {
        try {
            return new ResponseDTO(userBL.createUser(user));
        } catch (Exception ex) {
            LOG.error("Error al crear el usuario: ", ex);
            return new ResponseDTO("400", "No se pudo crear el usuario");
        }
    }

    @PutMapping("/{id}")
    public ResponseDTO updateUserById(@PathVariable Integer id, @RequestBody User user) {
        try {
            return new ResponseDTO(userBL.updateUserById(id, user));
        } catch (Exception ex) {
            LOG.error("Error al actualizar el usuario: ", ex);
            return new ResponseDTO("400", "No se pudo actualizar el usuario");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseDTO deleteUserById(@PathVariable Integer id) {
        try {
            userBL.deleteUserById(id);
            return new ResponseDTO("Usuario eliminado correctamente");
        } catch (Exception ex) {
            LOG.error("Error al eliminar el usuario: ", ex);
            return new ResponseDTO("400", "No se pudo eliminar el usuario");
        }
    }

    @PostMapping("/auth")
    public ResponseDTO authUser(@RequestBody LoginDTO auth) {
        try {
            return new ResponseDTO(userBL.verifyUserbyEmail(auth.getEmail()));
        } catch (Exception ex) {
            LOG.error("Error al autenticar el usuario: ", ex);
            return new ResponseDTO("400", "No se pudo autenticar el usuario");
        }
    }
}