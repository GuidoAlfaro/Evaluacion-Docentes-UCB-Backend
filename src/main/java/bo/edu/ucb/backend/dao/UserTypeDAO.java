package bo.edu.ucb.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import bo.edu.ucb.backend.entity.UserType;

public interface UserTypeDAO extends JpaRepository<UserType, Integer>{
    
}
