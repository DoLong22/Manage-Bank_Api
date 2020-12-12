package spring.repository;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.model.Level;

@Repository
@EntityScan(basePackages = {"spring.model.Level"})
public interface LevelRepository extends JpaRepository<Level, Integer>{

}
