package spring.controller;

import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import spring.model.Customer;
import spring.model.Person;
import spring.service.customer.CustomerService;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService ;

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> addCustomer(@Valid @RequestBody Person person){
        Customer customerAdded = this.customerService.addCustomer(person);
        if (customerAdded != null){
            return new ResponseEntity<>(customerAdded, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("fail", HttpStatus.SEE_OTHER);
        }
    }

    @GetMapping(value = "/{id}",produces = "application/json")
    public ResponseEntity<?> getCustomerById(@PathVariable int id){
        Customer customer =this.customerService.findCustomerById(id) ;
        if(customer != null){
            return new ResponseEntity<>(customer,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("fall",HttpStatus.SEE_OTHER) ;
        }
    }

    @GetMapping (produces = "application/json")
    public ResponseEntity<?> getAllCustomer(@RequestParam int page) {
        List <Customer > customers = this.customerService.getAllCustomer(page) ;
        if(customers != null){
            return new ResponseEntity<>(customers,HttpStatus.OK) ;
        }
        else {
            return  new ResponseEntity<>("fail",HttpStatus.SEE_OTHER) ;
        }
    }
    @GetMapping(value = "/idCustomer/{idCustomer}",produces = "application/json")
    public ResponseEntity<?> findByIdCustomer(@PathVariable String idCustomer){
        Customer customer = this.customerService.findByIdCustomer(idCustomer);
        if(customer != null){
            return  new ResponseEntity<>(customer ,HttpStatus.OK) ;
        }
        else {
            return new ResponseEntity<>("fail",HttpStatus.SEE_OTHER);
        }
    }

    @PutMapping(produces = "application/json")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer){
        Customer customerUpdate =this.customerService.updateCustomer(customer) ;
        if(customerUpdate != null){
            return new ResponseEntity<>("fail",HttpStatus.OK) ;
        }
        else {
            return new ResponseEntity<>("fail",HttpStatus.SEE_OTHER) ;
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int id){
        boolean doSucces = this.customerService.deleteCustomer(id) ;
        if(doSucces == true){
            return new ResponseEntity<>("delete successfull",HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("fail",HttpStatus.SEE_OTHER);
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

    @ExceptionHandler({ ConstraintViolationException.class })
    public Map<String, String> handleConstraintViolation(
            ConstraintViolationException ex) {
        Map<String, String> errors = new HashMap<>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            String fieldName = violation.getRootBeanClass().getName();
            String errorMessage = violation.getMessage();
            errors.put(fieldName, errorMessage);
        }
        return errors;
    }
//    @ExceptionHandler({ SQLIntegrityConstraintViolationException.class })
//    public Map<String, String> handleConstraintViolation(
//            SQLIntegrityConstraintViolationException ex) {
//        Map<String, String> errors = new HashMap<>();
//        System.out.println(ex.getLocalizedMessage());
//        for (ConstraintViolation<?> violation : ex.) {
//            String fieldName = violation.getRootBeanClass().getName();
//            String errorMessage = violation.getMessage();
//            errors.put(fieldName, errorMessage);
//        }
//        return errors;
//    }
}
