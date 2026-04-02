package ma.fstgm.security.shcoolmanagement.entities;

import jakarta.persistence.*;
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
    private String nom;
    private String code;


    @OneToMany(mappedBy = "professeur")
    private List<Course> courses;

    @ManyToOne
    @JoinColumn(name = "idDepartement" , nullable = false)
    private Departement departement;

}
