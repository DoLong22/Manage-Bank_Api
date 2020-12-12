package spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
    @NotBlank(message = "Home number cannot be blank")
    private String soNha;

    @Column(name="phuongxa")
    @NotBlank(message = "Commune cannot be blank")
    private String phuongXa;

    @Column(name="quanhuyen")
    @NotBlank(message = "District cannot be blank")
    private String quanHuyen;

    @Column(name="tinhthanhpho")
    @NotBlank(message = "City cannot be blank")
    private String tinhThanhpho;

}
