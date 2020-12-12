package spring.repository;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.model.Person;

@Repository
@EntityScan(basePackages = {"spring.model.Person"})
public interface PersonRepository extends JpaRepository<Person, Integer> {
    @Override
    Page<Person> findAll(Pageable pageable);

    Person findByCardNumber(String cardNumber);
}
