package spring.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import spring.model.*;
import spring.repository.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Component
public class ValidationBankAccount {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    public List<String> checkValidatetoCreate( String idEmployee, Person person){
        List<String> errors = new ArrayList<>();
        Employee employee = this.employeeRepository.findByIdEmployee(idEmployee);
        if (employee != null){
            Position currentPosition = employee.getPosition();
            if(!currentPosition.getViTri().equals("SALE")){
                errors.add("Employee dont have permission");
            }
        }else{
            errors.add("Employee dont exits");
        }
        Person existPerson = this.personRepository.findByCardNumber(person.getCardNumber());
        if(existPerson != null){
            Customer customer = this.customerRepository.findByPersonId(existPerson.getId());
            if(customer != null) {
                List<BankAccount> bankAccounts = this.bankAccountRepository.findBankAccountByCustomer(customer);
                int debit = 0;
                int credit = 0;
                for(BankAccount bankAccount: bankAccounts){
                    if(bankAccount.getTypeAccount().equals("CREDIT")){
                        credit = credit + 1;
                    }
                    if(bankAccount.getTypeAccount().equals("DEBIT")){
                        debit = debit + 1;
                    }
                }
                if (debit == 2){
                    errors.add("You just have less than 2 debit");
                }
                if (credit == 3){
                    errors.add("You just have less than 3 credit");
                }
            }
        }
        return errors;
    }

}
