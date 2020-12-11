package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import spring.model.Person;
import spring.service.address.AddressService;
import spring.service.person.PersonService;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> addPerson(@RequestBody Person person){
        Person personAdded = this.personService.addPerson(person);
        if (personAdded != null){
            return new ResponseEntity<>(personAdded, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("fail", HttpStatus.SEE_OTHER);
        }
    }
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> getPersonById(@PathVariable int id){
        Person person = this.personService.getPersonById(id);
        if (person != null){
            return new ResponseEntity<>(person, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("fail", HttpStatus.SEE_OTHER);
        }
    }
    @GetMapping(produces = "application/json")
    public ResponseEntity<?> getAllPerson(@RequestParam int page){
        List<Person> persons = this.personService.getAllPerson(page);
        if (persons != null){
            return new ResponseEntity<>(persons, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("fail", HttpStatus.SEE_OTHER);
        }
    }
    @PutMapping(produces = "application/json")
    public ResponseEntity<?> updatePerson(@RequestBody Person person){
        Person personUpdated = this.personService.updatePerson(person);
        if (personUpdated != null){
            return new ResponseEntity<>(personUpdated, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("fail", HttpStatus.SEE_OTHER);
        }
    }
    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable int id){
        boolean doSuccess = this.personService.deletePerson(id);
        if (doSuccess == true){
            return new ResponseEntity<>("delete successfull", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("fail", HttpStatus.SEE_OTHER);
        }
    }
}
