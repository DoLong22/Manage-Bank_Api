package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.model.Person;
import spring.model.Position;
import spring.service.person.PersonService;
import spring.service.position.PositionService;

import java.util.List;

@RestController
@RequestMapping("/position")
public class PositionController {
    @Autowired
    private PositionService positionService;

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> addPosition(@RequestBody Position position){
        Position positionAdded = this.positionService.addPosition(position);
        if (positionAdded != null){
            return new ResponseEntity<>(positionAdded, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("fail", HttpStatus.SEE_OTHER);
        }
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> getPositionById(@PathVariable int id){
        Position position = this.positionService.getPositionById(id);
        if (position != null){
            return new ResponseEntity<>(position, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("fail", HttpStatus.SEE_OTHER);
        }
    }

    @PutMapping(produces = "application/json")
    public ResponseEntity<?> updatePosition(@RequestBody Position position){
        Position positionUpdated = this.positionService.updatePosition(position);
        if (positionUpdated != null){
            return new ResponseEntity<>(positionUpdated, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("fail", HttpStatus.SEE_OTHER);
        }
    }
    @DeleteMapping(value="/{id}", produces = "application/json")
    public ResponseEntity<?> deletePosition(@PathVariable int id){
        boolean doSuccess = this.positionService.deletePosition(id);
        if (doSuccess == true){
            return new ResponseEntity<>("delete successfull", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("fail", HttpStatus.SEE_OTHER);
        }
    }

}