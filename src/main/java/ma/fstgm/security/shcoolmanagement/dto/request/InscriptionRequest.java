package ma.fstgm.security.shcoolmanagement.dto.request;

import java.time.LocalDate;

public record InscriptionRequest (
        LocalDate dateInscription
){
}
