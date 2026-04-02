package ma.fstgm.security.shcoolmanagement.dto.response;

import ma.fstgm.security.shcoolmanagement.entities.InscriptionPK;

import java.time.LocalDate;

public record InscriptionResponse(
        InscriptionPK id ,
        LocalDate dateInscription
) {
}
