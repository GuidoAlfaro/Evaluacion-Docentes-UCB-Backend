package bo.edu.ucb.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import bo.edu.ucb.backend.entity.Subject;

public interface SubjectDAO extends JpaRepository<Subject, Integer>{
    
}
