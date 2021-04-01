package spring.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Table(name = "nguoi")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "socmt")
    @NotNull(message = "Card number is require")
    private String cardNumber;

    @Column(name = "ngaysinh")
    @NotNull(message = "Date of birth is require")
    private Date ngaySinh;

    @Column(name = "email")
    @Email(message = "Email should be valid")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "diachiid", referencedColumnName = "id")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tenid", referencedColumnName = "id")
    private FullName fullName;

}
