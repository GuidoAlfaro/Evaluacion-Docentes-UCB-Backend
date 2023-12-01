package bo.edu.ucb.backend.dao;

import bo.edu.ucb.backend.dto.UserTypeDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import bo.edu.ucb.backend.entity.UserType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserTypeDAO extends JpaRepository<UserType, Integer>{

    @Query("SELECT new bo.edu.ucb.backend.dto.UserTypeDTO(u.userType.description) " +
            "FROM User u JOIN u.userType " +
            "WHERE u.email = :email")
    public UserTypeDTO findUserTypeById(@Param("email") String email);

}
