package spring.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

@Table(name = "Nguoi")
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

    @Column(name = "sodienthoai")
    @NotNull(message = "Phone number is require")
    @Pattern(regexp="^(\\d{3}[- .]?){2}\\d{4}$", message = "Phone number  is wrong. Phone number consists of 10 characters as a number")
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "diachiid", referencedColumnName = "id")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tenid", referencedColumnName = "id")
    private FullName fullName;
}
