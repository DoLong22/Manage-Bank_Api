package spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private String ho;

    @Column(name="tendem")
    private String tenDem;

    @Column(name="ten")
    private String ten;
}
