package ma.fstgm.security.shcoolmanagement.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.apache.catalina.LifecycleState;

import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Professeur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Nom obligatoire")
    private String nom;
    @NotBlank(message = "Code obligatoire")
    private String code;


    @OneToMany(mappedBy = "professeur")
    private List<Course> courses;

    @ManyToOne
    @JoinColumn(name = "idDepartement" , nullable = false)
    private Departement departement;

}
