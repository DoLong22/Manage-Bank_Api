package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import spring.model.Employee;
import spring.service.employee.EmployeeService;
import spring.validate.ValidationObject;

import java.util.List;

@RequestMapping("/employee")
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ValidationObject validated;

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
        List<String> errors = validated.getAllErrors(employee);
        if(!errors.isEmpty()){
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

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
    public ResponseEntity<?> getAllEmployee(@RequestParam int page){
        List<Employee> employees = this.employeeService.getAllEmployee(page);
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
