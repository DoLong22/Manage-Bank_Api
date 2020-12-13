package spring.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import spring.model.Customer;
import spring.model.Person;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Override
    Page<Customer> findAll(Pageable pageable);

    Customer findByIdCustomer(String idCustomer);
    Customer deleteByIdCustomer(String idCustomer);
    Customer findByPerson(Person person);
}
