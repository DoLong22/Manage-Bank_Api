package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.model.BankAccount;
import spring.model.Customer;

import java.util.List;

public interface BankAccountRepository extends JpaRepository<BankAccount,Integer> {

    List<BankAccount> findBankAccountByCustomer(Customer customer);
}
