package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.model.Address;
import spring.service.address.AddressService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> add(@RequestBody Address address){
        Address addressAdded = addressService.add(address);
        if (addressAdded != null){
            return new ResponseEntity<>(addressAdded, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("fail", HttpStatus.SEE_OTHER);
        }
    }

}
