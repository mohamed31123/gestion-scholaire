package ma.fstgm.security.shcoolmanagement.dto.response;

public record ProfesseurResponse(
        Long id ,
        String nom ,
        String code ,
        String nomDepartement
) {
}
