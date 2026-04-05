package ma.fstgm.security.shcoolmanagement.dto.request;

import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;

public record SemestreRequest (
        LocalDate annee,
        String nom
){
}
