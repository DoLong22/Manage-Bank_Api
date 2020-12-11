package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.model.Customer;
import spring.model.Person;
import spring.service.customer.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService ;

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
        System.out.println("customer.." + customer);
        Customer customerAdded = this.customerService.addCustomer(customer);
        if (customerAdded != null){
            return new ResponseEntity<>(customerAdded, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("fail", HttpStatus.SEE_OTHER);
        }
    }

    @GetMapping(value = "/{id}",produces = "application/json")
    public ResponseEntity<?> getCustomerById(@PathVariable int id){
        Customer customer =this.customerService.getCustomerById(id) ;
        if(customer != null){
            return new ResponseEntity<>(customer,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("fall",HttpStatus.SEE_OTHER) ;
        }
    }


}
