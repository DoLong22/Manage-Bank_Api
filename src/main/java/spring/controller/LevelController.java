package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.model.Level;
import spring.model.Position;
import spring.service.level.LevelService;
import spring.service.position.PositionService;

@RestController
@RequestMapping("/level")
public class LevelController {
    @Autowired
    private LevelService levelService;

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> addPosition(@RequestBody Level level){
        Level levelAdded = this.levelService.addLevel(level);
        if (levelAdded != null){
            return new ResponseEntity<>(levelAdded, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("fail", HttpStatus.SEE_OTHER);
        }
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> getPositionById(@PathVariable int id){
        Level level = this.levelService.getLevelById(id);
        if (level != null){
            return new ResponseEntity<>(level, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("fail", HttpStatus.SEE_OTHER);
        }
    }

    @PutMapping(produces = "application/json")
    public ResponseEntity<?> updatePosition(@RequestBody Level position){
        Level level = this.levelService.updateLevel(position);
        if (level != null){
            return new ResponseEntity<>(level, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("fail", HttpStatus.SEE_OTHER);
        }
    }

    @DeleteMapping(value="/{id}", produces = "application/json")
    public ResponseEntity<?> deletePosition(@PathVariable int id){
        boolean doSuccess = this.levelService.deleteLevel(id);
        if (doSuccess == true){
            return new ResponseEntity<>("delete successfull", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("fail", HttpStatus.SEE_OTHER);
        }
    }
}
