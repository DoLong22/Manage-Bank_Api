package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import spring.model.*;
import spring.service.bankaccount.BankAccountService;
import spring.service.customer.CustomerService;
import spring.service.employee.EmployeeService;
import spring.service.person.PersonService;
import spring.service.registing.RegistingService;
import spring.validate.ValidationBankAccount;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/registing")
public class RegistingController {

    @Autowired
    private RegistingService registingService;
    @Autowired
    private BankAccountService bankAccountService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ValidationBankAccount validationBankAccount;
    @Autowired
    private PersonService personService;
    @Autowired
    private EmployeeService employeeService;

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> createBankAccount(@RequestBody InfomationRegisting infomationRegisting) {
        infomationRegisting.setIdEmployee("5211212");
        List<String> errors = this.validationBankAccount.checkValidatetoCreate(infomationRegisting.getIdEmployee(), infomationRegisting.getPerson());
        if (!errors.isEmpty()) {
            return new ResponseEntity<>(errors, HttpStatus.FORBIDDEN);
        } else {
            Customer customerRegister = checkPerson(infomationRegisting.getPerson());
            infomationRegisting.getBankAccount().setCustomer(customerRegister);
            BankAccount bankAccountAdded = this.bankAccountService.addBankAccount(infomationRegisting.getBankAccount());
            if (bankAccountAdded != null){
                Employee employee = this.employeeService.findByIdEmployee(infomationRegisting.getIdEmployee());
                Registing registing = registingService.createRegisting(employee, infomationRegisting.getBankAccount(), infomationRegisting.getCurrentDate());
                if (registing != null) {
                    return new ResponseEntity<>(registing, HttpStatus.OK);
                } else {
                    return new ResponseEntity<>("fail", HttpStatus.SEE_OTHER);
                }
            }else {
                return new ResponseEntity<>("fail", HttpStatus.SEE_OTHER);
            }

        }
    }

    public Customer checkPerson(Person personRegister) {
        Person existPerson = this.personService.findByCardNumber(personRegister.getCardNumber());
        Customer customerRegister = new Customer();
        if (existPerson != null) {
//            customerRegister = this.customerService.findCustomerById(personRegister.getId());
            customerRegister = this.customerService.findByPersonId(personRegister.getId());
//                customerRegister = this.customerService.findByPerson(personRegister);
            return customerRegister;
        } else {
            customerRegister = this.customerService.addCustomer(personRegister);
            return customerRegister;
        }
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> getCustomerById(@PathVariable int id) {
        Registing registing = this.registingService.getRegistingById(id);
        if (registing != null) {
            return new ResponseEntity<>(registing, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("fall", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<?> getAllCustomer(@RequestParam int page) {
        List<Registing> registing = this.registingService.getAllRegisting(page);
        if (registing != null) {
            return new ResponseEntity<>(registing, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("fail", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(produces = "application/json")
    public ResponseEntity<?> updateCustomer(@RequestBody Registing registing) {
        Registing registingUpdate = this.registingService.updateRegisting(registing);
        if (registingUpdate != null) {
            return new ResponseEntity<>(registingUpdate, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("fail", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int id) {
        boolean doSucces = this.registingService.deleteRegisting(id);
        if (doSucces == true) {
            return new ResponseEntity<>("delete successfull", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("fail", HttpStatus.SEE_OTHER);
        }
    }

//    @PostMapping(value = "/valid-create")
//    public ResponseEntity<?> checkValidatetoCreate(@RequestParam String idEmployee, @RequestParam String cardNumber) {
//        List<String> errors = this.validationBankAccount.checkValidatetoCreate(idEmployee, cardNumber);
//        if (errors != null) {
//            return new ResponseEntity<>(errors, HttpStatus.FORBIDDEN);
//        } else {
//            return new ResponseEntity<>("", HttpStatus.OK);
//        }
//    }

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

    @ExceptionHandler({ConstraintViolationException.class})
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
