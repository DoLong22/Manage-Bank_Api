package spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Table(name = "vitri_congviec")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Position implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="vitricv")
    @NotBlank(message = "Position cannot be blank")
    private String viTri;

    @Column(name="luongcoban")
    @NotNull(message = "Basic salary is require")
    private float luong;

}
