package spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Table(name = "dangki")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Registing implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="ngaydangki")
    @NotNull(message = "Date of register is requied")
    private Date dateOfRegister;

    @OneToOne
    @JoinColumn(name="taikhoannhid",referencedColumnName = "id")
    private BankAccount bankAccount ;

    @OneToOne
    @JoinColumn(name="nhanvienid",referencedColumnName = "id")
    private Employee employee ;
}
