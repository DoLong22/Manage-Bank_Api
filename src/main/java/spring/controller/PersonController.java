package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import spring.model.Person;
import spring.service.person.PersonService;

import java.util.List;

import spring.service.person.PersonService;
import spring.validate.ValidationObject;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private ValidationObject validated;

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> addPerson(@Valid @RequestBody Person person) {
        Person personAdded = this.personService.addPerson(person);
        if (personAdded != null) {
            return new ResponseEntity<>(personAdded, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("fail", HttpStatus.SEE_OTHER);
        }
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> getPersonById(@PathVariable int id) {
        Person person = this.personService.getPersonById(id);
        if (person != null) {
            return new ResponseEntity<>(person, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("fail", HttpStatus.SEE_OTHER);
        }
    }

    @GetMapping(value = "/card-number/{cardNumber}", produces = "application/json")
    public ResponseEntity<?> findByCardNumber(@PathVariable String cardNumber) {
        Person person = this.personService.findByCardNumber(cardNumber);
        if (person != null) {
            return new ResponseEntity<>(person, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("fail", HttpStatus.SEE_OTHER);
        }
    }

    @GetMapping(value = "/phone-number/{phoneNumber}", produces = "application/json")
    public ResponseEntity<?> findByPhoneNumber(@PathVariable String phoneNumber) {
        Person person = this.personService.findByCardNumber(phoneNumber);
        if (person != null) {
            return new ResponseEntity<>(person, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("fail", HttpStatus.SEE_OTHER);
        }
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<?> getAllPerson(@RequestParam int page) {
        List<Person> persons = this.personService.getAllPerson(page);
        if (persons != null) {
            return new ResponseEntity<>(persons, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("fail", HttpStatus.SEE_OTHER);
        }
    }

    @PutMapping(produces = "application/json")
    public ResponseEntity<?> updatePerson(@RequestBody Person person) {
        Person personUpdated = this.personService.updatePerson(person);
        if (personUpdated != null) {
            return new ResponseEntity<>(personUpdated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("fail", HttpStatus.SEE_OTHER);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable int id) {
        boolean doSuccess = this.personService.deletePerson(id);
        if (doSuccess == true) {
            return new ResponseEntity<>("delete successfull", HttpStatus.OK);
        } else {
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
