package ma.fstgm.security.shcoolmanagement.dto.request;

public record ProfesseurRequest(
        String nom ,
        String code ,
        Long idDepartement
) {
}
