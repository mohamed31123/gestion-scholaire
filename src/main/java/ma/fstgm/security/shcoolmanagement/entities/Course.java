package ma.fstgm.security.shcoolmanagement.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "cours")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomCours ;
    private String code ;

    @OneToMany(mappedBy = "cours")
    private List<Inscription> inscriptions;

    //la relation entre le prof et le cours
    @ManyToOne
    @JoinColumn(name = "idProf")
    private Professeur professeur;

    //la relation entre le course et le semestre
    @ManyToOne
    @JoinColumn(name = "idSemestre")
    private Semestre semestre;


}
