package spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private int bacNghe;

    @Column(name="hsluong")
    private float hsLuong;

}
