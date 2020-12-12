package spring.service.customer;

import spring.model.Customer;
import java.util.List;

public interface CustomerService {
    public Customer addCustomer(Customer customer) ;

    public Customer updateCustomer(Customer customer);

    public boolean deleteCustomer(int id);

    public List<Customer> getAllCustomer(int page);

    public Customer getCustomerById(int id);

    public List<Customer> searchCustomerByMasoKh(String masoKh) ;
}
