package spring.service.employee;

import org.springframework.data.domain.Pageable;
import spring.model.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee addEmployee(Employee employee);

    public Employee updateEmployee(Employee employee);

    public boolean deleteEmployee(int id);

    public List<Employee> getAllEmployee(Pageable pageable);

    public Employee getEmployeeById(int id);

}
