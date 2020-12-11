package spring.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import spring.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Override
    Page<Customer> findAll(Pageable pageable);
}
