package spring.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import spring.model.Employee;

import spring.model.Person;
import spring.repository.EmployeeRepository;

import spring.repository.PersonRepository;
import spring.service.employee.EmployeeService;
import spring.service.person.PersonService;


import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceIml implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PersonService personService;

    @Override
    public Employee addEmployee(Employee employee) {
        return this.employeeRepository.save((employee));
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Employee exitsEmployee = this.employeeRepository.findById(employee.getId()).orElse(null);
        if(exitsEmployee != null){
            exitsEmployee = employeeRepository.saveAndFlush(employee);
        }
        System.out.println(exitsEmployee);
        return  exitsEmployee;
    }

    @Override
    public boolean deleteEmployee(int id) {
        boolean isDeleted = false;
        Employee employee = this.employeeRepository.findById(id).orElse(null);
        if(employee != null ){
            this.employeeRepository.deleteById(id);
            isDeleted = true;
        }
        return isDeleted;
    }

    @Override
    public List<Employee> getAllEmployee( int page) {
        List<Employee> listEmployee = this.employeeRepository.findAll(PageRequest.of(page, 20)).getContent();
        return listEmployee;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = this.employeeRepository.findById(id).orElse(null);
        return employee;
    }

    @Override
    public Employee findByIdEmployee(String idNhanvien) {
        Employee employee = this.employeeRepository.findByIdEmployee(idNhanvien);
        return employee;
    }

    @Override
    public List<Employee> getListEmployeeByName(String lastName) {
        List<Person> personList = personService.getListPersonByName(lastName);
        List<Employee> employeeList = new ArrayList<>();
        if (!personList.isEmpty()) {
            for (Person person : personList) {
                Employee employee = employeeRepository.findByPerson(person);
                if (person != null) {
                    employeeList.add(employee);
                }
            }
            return employeeList;
        } else {
            return null;
        }
    }
}
