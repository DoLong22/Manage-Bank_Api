package spring.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Table(name = "vitri_congviec")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private int id;

    @Column(name = "vitricv")
    private String viTriCv;

    @Column(name = "luongcoban")
    private float luong;
}
