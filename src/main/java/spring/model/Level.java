package spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
    @Min(value = 1, message = "Bac nghe should not be less than 1")
    @Max(value = 7, message = "Bac nghe should not be greater than 7")
    private int bacNghe;

    @Column(name="hsluong")
    @NotNull(message = "Coefficients salary is require")
    private float hsLuong;

}
