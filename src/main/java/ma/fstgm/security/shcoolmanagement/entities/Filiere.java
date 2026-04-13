package ma.fstgm.security.shcoolmanagement.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "le nom est obligatoire")
    private String nom;
    @NotBlank(message = "le code est obligatoire")
    private String code ;
    @OneToMany(mappedBy = "filiere")
    private List<Student> students;

}
