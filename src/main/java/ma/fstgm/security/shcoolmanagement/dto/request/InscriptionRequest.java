package ma.fstgm.security.shcoolmanagement.dto.request;

import java.time.LocalDate;

public record InscriptionRequest (
        Long idStudent ,
        Long idCours ,
        LocalDate dateInscription
){
}
