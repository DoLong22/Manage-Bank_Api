package spring.service.employee;

import org.springframework.data.domain.Pageable;
import spring.model.Employee;
import spring.model.Person;

import java.util.List;

public interface EmployeeService {

    public Employee addEmployee(Employee employee);

    public Employee updateEmployee(Employee employee);

    public boolean deleteEmployee(int id);

    public List<Employee> getAllEmployee(int page);

    public Employee getEmployeeById(int id);

    public Employee findByIdEmployee(String idNhanvien);

    public List<Employee> getListEmployeeByName(String employeeName);

}
