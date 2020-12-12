package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import spring.model.Customer;
import spring.model.Registing;
import spring.service.registing.RegistingService;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/registing")
public class RegistingController {

    @Autowired
    private RegistingService registingService;

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> addCustomer(@Valid @RequestBody Registing registing){
        Registing registingAdded = this.registingService.createRegisting(registing);
        if (registingAdded != null){
            return new ResponseEntity<>(registingAdded, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("fail", HttpStatus.SEE_OTHER);
        }
    }

    @GetMapping(value = "/{id}",produces = "application/json")
    public ResponseEntity<?> getCustomerById(@PathVariable int id){
        Registing registing =this.registingService.getRegistingById(id) ;
        if(registing != null){
            return new ResponseEntity<>(registing,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("fall",HttpStatus.SEE_OTHER) ;
        }
    }

    @GetMapping (produces = "application/json")
    public ResponseEntity<?> getAllCustomer(@RequestParam int page) {
        List<Registing > registing = this.registingService.getAllRegisting(page) ;
        if(registing != null){
            return new ResponseEntity<>(registing, HttpStatus.OK) ;
        }
        else {
            return  new ResponseEntity<>("fail",HttpStatus.SEE_OTHER) ;
        }
    }

    @PutMapping(produces = "application/json")
    public ResponseEntity<?> updateCustomer(@RequestBody Registing registing){
        Registing registingUpdate =this.registingService.updateRegisting(registing) ;
        if(registingUpdate != null){
            return new ResponseEntity<>(registingUpdate,HttpStatus.OK) ;
        }
        else {
            return new ResponseEntity<>("fail",HttpStatus.SEE_OTHER) ;
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int id){
        boolean doSucces = this.registingService.deleteRegisting(id) ;
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
}
