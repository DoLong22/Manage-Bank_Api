package spring.repository;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.model.Customer;

@Repository
@EntityScan(basePackages = {"spring.model.Customer"})
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Override
    Page<Customer> findAll(Pageable pageable);

    Customer findByIdCustomer(String idCustomer);
}
