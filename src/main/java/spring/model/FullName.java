package spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Table(name = "ten")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullName implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="ho")
    @NotBlank(message = "First name cannot be blank")
    private String ho;

    @Column(name="tendem")
    @NotBlank(message = "First name cannot be blank")
    private String tenDem;

    @Column(name="ten")
    @NotBlank(message = "First name cannot be blank")
    private String ten;
}
