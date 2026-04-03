package ma.fstgm.security.shcoolmanagement.dto.response;

import ma.fstgm.security.shcoolmanagement.entities.InscriptionPK;

import java.time.LocalDate;

public record InscriptionResponse(
        Long idStudent ,
        Long idCourse ,
        LocalDate dateInscription ,
        String nomCours ,
        String firstName ,
        String lastName
) {
}
