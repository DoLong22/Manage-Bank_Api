package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
