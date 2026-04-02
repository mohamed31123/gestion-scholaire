package ma.fstgm.security.shcoolmanagement.entities;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter
@Setter
@ToString
public class Inscription {
    @EmbeddedId
    private InscriptionPK id ;
    private LocalDate dateInscription ;


    //ca c'est une classe d'association donc il doit contenier les cles etrangere
    //c'une cle compose
    @ManyToOne
    @JoinColumn(name = "idCourse", nullable = false)
    private Course course ;
    @ManyToOne
    @JoinColumn(name = "idStudent")
    private Student student ;

}
