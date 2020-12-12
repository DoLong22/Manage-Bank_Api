package spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Table(name = "bacnghe")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Level implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="bacnghe")
    @NotNull(message = "Job level is requied")
    @Size(min = 1, max = 8, message
            = "Job level be between 10 and 200 characters")
    private int bacNghe;

    @Column(name="hsluong")
    @NotNull(message = "Coefficients salary is require")
    private float hsLuong;

}
