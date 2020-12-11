package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import spring.model.Employee;
import spring.service.employee.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
        Employee EmployeeAdded = this.employeeService.addEmployee(employee);
        if (EmployeeAdded != null){
            return new ResponseEntity<>(EmployeeAdded, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("fail", HttpStatus.SEE_OTHER);
        }
    }
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> getEmployeeById(@PathVariable int id){
        Employee employee = this.employeeService.getEmployeeById(id);
        if (employee != null){
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("fail", HttpStatus.SEE_OTHER);
        }
    }
    @GetMapping(produces = "application/json")
    public ResponseEntity<?> getAllEmployee(Pageable pageable){
        List<Employee> employees = this.employeeService.getAllEmployee(pageable);
        if (employees != null){
            return new ResponseEntity<>(employees, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("fail", HttpStatus.SEE_OTHER);
        }
    }
    @PutMapping(produces = "application/json")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee){
        Employee employeeUpdated = this.employeeService.updateEmployee(employee);
        if (employeeUpdated != null){
            return new ResponseEntity<>(employeeUpdated, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("fail", HttpStatus.SEE_OTHER);
        }
    }
    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable int id){
        boolean doSuccess = this.employeeService.deleteEmployee(id);
        if (doSuccess == true){
            return new ResponseEntity<>("delete successfull", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("fail", HttpStatus.SEE_OTHER);
        }
    }
}
