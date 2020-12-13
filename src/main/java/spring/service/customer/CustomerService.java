package spring.service.customer;

import spring.model.Customer;
import spring.model.Person;

import java.util.List;

public interface CustomerService {

    Customer addCustomer(Customer customer) ;

    Customer addCustomer(Person person) ;

    Customer updateCustomer(Customer customer);

    boolean deleteCustomer(int id);

    List<Customer> getAllCustomer(int page);

    Customer getCustomerById(int id);

    Customer findByIdCustomer(String idCustomer) ;

    Customer findByPerson(Person person) ;

}
