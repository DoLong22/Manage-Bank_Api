package spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InfomationRegisting {

    private Person person;
    private String idEmployee;
    private BankAccount bankAccount;
    private Date currentDate;

}
