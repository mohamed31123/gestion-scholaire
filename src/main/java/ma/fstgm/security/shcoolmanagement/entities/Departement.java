package ma.fstgm.security.shcoolmanagement.entities;


import jakarta.persistence.*;
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
    private String nom ;
    @OneToMany(mappedBy = "departement")
    private List<Professeur> professeurs;

}
