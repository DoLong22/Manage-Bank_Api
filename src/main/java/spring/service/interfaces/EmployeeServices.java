package spring.service.interfaces;

import spring.model.Employee;

import java.util.List;

public interface EmployeeServices {

    Employee addEmployee(Employee employee);
    boolean deleteEmployee(int id);
    Employee updateEmployee(Employee employee);
    List<Employee> searchByNameEmployee(String name);

}
