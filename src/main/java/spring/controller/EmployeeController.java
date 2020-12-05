//package spring.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import spring.model.Employee;
//import spring.service.interfaces.EmployeeServices;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/employee")
//public class EmployeeController {
//
//    @Autowired
//    private EmployeeServices employeeServices;
//
//    @PostMapping(produces = "application/json")
//    public ResponseEntity<?> addNewImployee(@RequestBody Employee employee){
//        Employee createdEmployee = employeeServices.addEmployee(employee);
//        if(createdEmployee == null ){
//            return new ResponseEntity<>( createdEmployee, HttpStatus.SEE_OTHER);
//        } else {
//            return new ResponseEntity<>(createdEmployee, HttpStatus.OK);
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteImployee(@PathVariable("id") int id){
//        boolean resultHandle = employeeServices.deleteEmployee(id);
//        if(resultHandle){
//            return new ResponseEntity<>("Delete success", HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("Delete fail", HttpStatus.SEE_OTHER);
//
//        }
//    }
//
//    @PutMapping(produces = "application/json")
//    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee){
//        Employee createdEmployee = employeeServices.addEmployee(employee);
//        if(createdEmployee == null ){
//            return new ResponseEntity<>( createdEmployee, HttpStatus.SEE_OTHER);
//        } else {
//            return new ResponseEntity<>(createdEmployee, HttpStatus.OK);
//        }
//    }
//
//    @PutMapping(produces = "application/json")
//    public ResponseEntity<?> searchByNameEmployee(@RequestBody String name){
//        List<Employee> employees = employeeServices.searchByNameEmployee(name);
//        if(!employees.isEmpty()){
//            return new ResponseEntity<>( employees, HttpStatus.SEE_OTHER);
//        } else {
//            return new ResponseEntity<>(employees, HttpStatus.OK);
//        }
//    }
//}