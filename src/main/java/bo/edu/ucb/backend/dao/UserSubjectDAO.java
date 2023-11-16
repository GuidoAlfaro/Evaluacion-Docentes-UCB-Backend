package bo.edu.ucb.backend.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import bo.edu.ucb.backend.entity.UserSubject;

public interface UserSubjectDAO extends JpaRepository<UserSubject, Integer>{
    
}