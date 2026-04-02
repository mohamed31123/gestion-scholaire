package ma.fstgm.security.shcoolmanagement.entities;


import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
public class InscriptionPK implements Serializable {
    private Long idCourse ;
    private Long idStudent ;



}
