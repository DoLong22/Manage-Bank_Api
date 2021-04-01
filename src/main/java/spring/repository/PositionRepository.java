package spring.repository;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.model.Employee;
import spring.model.Position;

import java.util.List;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {

    public Position findPositionByViTri(String viTri);
}