package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.model.FullName;

import java.util.List;

@Repository
public interface FullNameRepository extends JpaRepository<FullName, Integer> {

    List<FullName> findByTen(String ten);
}
