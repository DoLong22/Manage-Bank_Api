package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.model.Position;

public interface PositionRepository extends JpaRepository<Position, Integer> {
}
