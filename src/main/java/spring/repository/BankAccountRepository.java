package spring.repository;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.model.BankAccount;
import spring.model.Customer;

import java.util.List;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount,Integer> {

    List<BankAccount> findBankAccountByCustomer(Customer customer);
}
