package spring.repository;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.model.Employee;
import spring.model.Position;

import java.util.List;
//@Repository
//@EntityScan(basePackages = {"spring.model.Employee"})
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Override
    Page<Employee> findAll(Pageable pageable);

    Employee findByIdEmployee(String idNhanvien);

    List<Employee> findEmployeeByPosition(Position position);
}
