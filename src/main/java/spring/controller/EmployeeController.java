package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import spring.model.Employee;
import spring.service.employee.EmployeeService;
import spring.validate.ValidationObject;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ValidationObject validated;

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> addEmployee(@Valid @RequestBody Employee employee){
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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
