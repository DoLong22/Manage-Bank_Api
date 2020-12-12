package spring.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "nhanvien")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "thamnien")
    private int thamNien;

    @Column(name = "masonv")
    private String idNhanvien;

    @ManyToOne
    @JoinColumn(name = "bacngheid", referencedColumnName = "id")
    private Level level ;

    @ManyToOne
    @JoinColumn(name = "vitricvid", referencedColumnName = "id")
    private Position position;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nguoiid", referencedColumnName = "id")
    private Person person;
}

