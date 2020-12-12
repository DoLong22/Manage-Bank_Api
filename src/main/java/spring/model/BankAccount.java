package spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "taikhoannganhang")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="sotaikhoan")
    @NotNull(message = "Bank Account is requied")
    private float bankAccount;

    @Column(name="kieutaikhoan")
    @NotNull(message = "Type account is requied")
    private String typeAccount;

    @Column(name="sodu")
    @NotNull(message = "Account balance is requied")
    private String accountBalance;

    @ManyToOne
    @JoinColumn(name = "hangtaikhoanid", referencedColumnName = "id")
    private AccountClass accountClass;

    @ManyToOne
    @JoinColumn(name = "khachhangid", referencedColumnName = "id")
    private Customer customer;
}
