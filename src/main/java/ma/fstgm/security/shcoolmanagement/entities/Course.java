package ma.fstgm.security.shcoolmanagement.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "le nom de cours est obligatoire")
    private String nomCours;
    @NotBlank(message = "le code de cours est obligatoire")
    private String code;

    @OneToMany(mappedBy = "course")
    private List<Inscription> inscriptions;

    //la relation entre le prof et le cours
    @ManyToOne
    @JoinColumn(name = "idProf")
    @JsonBackReference
    private Professeur professeur;

    //la relation entre le course et le semestre
    @ManyToOne
    @JoinColumn(name = "idSemestre")
    private Semestre semestre;


}
