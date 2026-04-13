package ma.fstgm.security.shcoolmanagement.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@Getter @Setter
@ToString
@NoArgsConstructor @AllArgsConstructor

public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @NotBlank(message = "le nom de departement est obligatoire")
    private String nom ;
    @OneToMany(mappedBy = "departement")
    private List<Professeur> professeurs;

}
