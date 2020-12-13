package spring.service.customer;
import com.devskiller.friendly_id.FriendlyId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import spring.model.Customer;
import spring.model.Person;
import spring.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerServicelml implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    private String generateId(){
        String friendId = FriendlyId.createFriendlyId();

        return friendId;
    }

    @Override
    public Customer addCustomer(Customer customer){
        return this.customerRepository.save(customer) ;
    }

    @Override
    public Customer addCustomer(Person person) {
        String idCustomer = generateId();
        Customer customer = new Customer();
        customer.setPerson(person);
        customer.setIdCustomer(idCustomer);
        return this.customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer exitsCustomer = this.customerRepository.findById(customer.getId()).orElse(null);
        if(exitsCustomer != null){
            exitsCustomer = customerRepository.saveAndFlush(customer);
        }
        return  exitsCustomer;
    }

    @Override
    public boolean deleteCustomer(int id) {
        boolean isDeleted = false;
        Customer customer = this.customerRepository.findById(id).orElse(null);
        if(customer != null ){
            this.customerRepository.deleteById(id);
            isDeleted = true;
        }
        return isDeleted;
    }

    @Override
    public List<Customer> getAllCustomer(int page) {
        List<Customer> listCustomer = this.customerRepository.findAll(PageRequest.of(page, 20)).getContent();
        return listCustomer ;
    }

    @Override
    public Customer getCustomerById(int id) {
        Customer customer = this.customerRepository.findById(id).orElse(null);
        return customer;
    }

    @Override
    public Customer findByIdCustomer(String idCustomer) {
        Customer customer = this.customerRepository.findByIdCustomer(idCustomer);
        return  customer ;
    }

    @Override
    public Customer findByPerson(Person person) {
        return this.customerRepository.findByPerson(person);
    }
}
