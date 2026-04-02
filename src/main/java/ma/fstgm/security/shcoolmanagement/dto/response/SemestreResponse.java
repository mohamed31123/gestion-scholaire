package ma.fstgm.security.shcoolmanagement.dto.response;

import java.time.LocalDate;

public record SemestreResponse(
        Long id ,
        LocalDate annee
) {
}
