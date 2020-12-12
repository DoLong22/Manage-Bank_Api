package spring.repository;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.model.Position;

@Repository
@EntityScan(basePackages = {"spring.model.Position"})
public interface PositionRepository extends JpaRepository<Position, Integer> {
}
