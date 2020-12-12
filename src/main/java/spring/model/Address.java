package spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
//    @NotNull(message = "Job level is requied")
    @NotBlank(message = "Home number cannot be blank")
    private String soNha;

    @Column(name="phuongxa")
//    @NotNull(message = "Job level is requied")
    @NotBlank(message = "Commune cannot be blank")
    private String phuongXa;

    @Column(name="quanhuyen")
//    @NotNull(message = "Job level is requied")
    @NotBlank(message = "District cannot be blank")
    private String quanHuyen;

    @Column(name="tinhthanhpho")
    @NotBlank(message = "City cannot be blank")
    private String tinhThanhpho;

}
