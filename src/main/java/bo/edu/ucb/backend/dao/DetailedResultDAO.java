package bo.edu.ucb.backend.dao;

import bo.edu.ucb.backend.entity.DetailedResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailedResultDAO extends JpaRepository<DetailedResult, Integer> {
}
