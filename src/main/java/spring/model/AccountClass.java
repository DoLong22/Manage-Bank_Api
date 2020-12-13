package spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "hangtaikhoan")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="hangtaikhoan")
    @NotNull(message = "Account class is requied")
    private String accountClass;

    @Column(name="sodutoithieu")
    @NotNull(message = "Minimum balance is requied")
    private float minimumBalance;

    @Column(name="dinhmuc")
    @NotNull(message = "Credit ationing is requied")
    private float rationing;
}
