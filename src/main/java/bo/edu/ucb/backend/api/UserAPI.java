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
public class UserAPI {
    private static final Logger LOG = LoggerFactory.getLogger(UserAPI.class);
    @Autowired
    private UserBL userBL;

    @PostMapping("api/v1/auth")
    public ResponseDTO login(@RequestBody LoginDTO loginDTO) {
        try {
            LOG.info("Buscando al usuario con correo: {}", loginDTO.getEmail());
            return new ResponseDTO(userBL.login(loginDTO.getEmail()));
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se buscaba al usuario: ", ex);
            return new ResponseDTO("400", "Ocurrio un error mientras se buscaba al usuario");
        }
    }
}