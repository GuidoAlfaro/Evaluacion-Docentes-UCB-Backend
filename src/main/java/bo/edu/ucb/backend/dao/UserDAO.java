package bo.edu.ucb.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import bo.edu.ucb.backend.entity.User;

public interface UserDAO extends JpaRepository<User, Integer>{
    
}
