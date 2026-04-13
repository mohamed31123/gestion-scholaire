package ma.fstgm.security.shcoolmanagement.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Semestre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Nom Obligatoire")
    private String nom;
    @NotNull(message = "Annee Obligatoire")
    private LocalDate annee ;

    @OneToMany(mappedBy = "semestre")
    private List<Course> courses ;
}
