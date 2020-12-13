package spring.service.registing;

import spring.model.BankAccount;
import spring.model.Customer;
import spring.model.Employee;
import spring.model.Registing;

import java.util.Date;
import java.util.List;

public interface RegistingService {

     Registing createRegisting(Registing registing);

     Registing createRegisting(Employee employee, BankAccount bankAccount, Date date);

     boolean deleteRegisting(int id);

     Registing updateRegisting(Registing registing);

     List<Registing> getAllRegisting(int page);

     Registing getRegistingById(int id);

}
