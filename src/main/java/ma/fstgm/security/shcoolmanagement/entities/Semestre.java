package ma.fstgm.security.shcoolmanagement.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Semestre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private LocalDate annee ;

    @OneToMany(mappedBy = "semestre")
    private List<Course> courses ;
}
