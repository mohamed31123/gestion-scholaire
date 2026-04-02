package ma.fstgm.security.shcoolmanagement.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "filieres")
@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class Filiere {
    @Id @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
    private String nom;
    private String code ;
    @OneToMany(mappedBy = "filiere")
    private List<Student> students;

}
