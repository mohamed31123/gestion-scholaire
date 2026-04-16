package ma.fstgm.security.shcoolmanagement.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Inscription {
    @EmbeddedId
    private InscriptionPK id;
    @NotNull(message = "Date obligatoire")
    private LocalDate dateInscription;


    //ca c'est une classe d'association donc il doit contenier les cles etrangere
    //c'une cle compose
    @ManyToOne
    @MapsId("idCourse")
    @JoinColumn(name = "idCourse", nullable = false)
    private Course course;

    @ManyToOne
    @MapsId("idStudent")
    @JoinColumn(name = "idStudent" , nullable = false)
    private Student student;

}
