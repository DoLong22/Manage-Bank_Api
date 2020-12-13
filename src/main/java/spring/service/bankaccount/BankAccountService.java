package spring.service.bankaccount;

import spring.model.BankAccount;
import spring.model.Employee;

import java.util.List;

public interface BankAccountService {

    BankAccount addBankAccount(BankAccount account);

    BankAccount updateBankAccount(BankAccount account);

    boolean deleteBankAccount(int id);

    List<BankAccount> getAllBankAccount(int page);

    BankAccount getBankAccountById(int id);

//    BankAccount findByIdAccount(String idNhanvien);


}
