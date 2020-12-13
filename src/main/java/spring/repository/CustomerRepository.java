package spring.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.model.Customer;
import spring.model.Person;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Override
    Page<Customer> findAll(Pageable pageable);
    Customer getCustomerByPerson(Person person);
    Customer findByIdCustomer(String idCustomer);
    Customer findByPerson(Person person);

    @EntityGraph(value = "Customer.person",attributePaths = {"person"}, type = EntityGraph.EntityGraphType.FETCH)
    Customer findByPersonId(int id);

//    @Query("from Customer cus inner join fetch cus.person where cus. = :id")
//    Customer findByPersonId(@Param("id") int id);

}
