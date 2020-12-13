package spring.service.bankaccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.model.BankAccount;
import spring.repository.BankAccountRepository;

import java.util.List;
@Service
public class BankAccountIml implements BankAccountService{
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Override
    public BankAccount addBankAccount(BankAccount account) {
        return  this.bankAccountRepository.save(account);
    }

    @Override
    public BankAccount updateBankAccount(BankAccount account) {
        return null;
    }

    @Override
    public boolean deleteBankAccount(int id) {
        return false;
    }

    @Override
    public List<BankAccount> getAllBankAccount(int page) {
        return null;
    }

    @Override
    public BankAccount getBankAccountById(int id) {
        return null;
    }
}
