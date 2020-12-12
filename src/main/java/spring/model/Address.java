package spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Table(name = "diachi")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="sonha")
    private String soNha;

    @Column(name="phuongxa")
    private String phuongXa;

    @Column(name="quanhuyen")
    private String quanHuyen;

    @Column(name="tinhthanhpho")
    private String tinhThanhpho;

}
