package ma.fstgm.security.shcoolmanagement.mapper;

import ma.fstgm.security.shcoolmanagement.dto.request.ProfesseurRequest;
import ma.fstgm.security.shcoolmanagement.dto.response.ProfesseurResponse;
import ma.fstgm.security.shcoolmanagement.entities.Departement;
import ma.fstgm.security.shcoolmanagement.entities.Professeur;
import org.springframework.stereotype.Component;

@Component
public class ProfesseurMapper {
    public Professeur toEntity(ProfesseurRequest dto , Departement departement) {
        Professeur prof = new Professeur();
        prof.setNom(dto.nom());
        prof.setCode(dto.code());
        prof.setDepartement(departement);
        return prof;
    }

    public ProfesseurResponse toResponse(Professeur professeur) {
        return new ProfesseurResponse(
                professeur.getId(),
                professeur.getNom(),
                professeur.getCode(),
                professeur.getDepartement().getNom()
        );
    }

    public void updateProfesseur(Professeur professeur, ProfesseurRequest professeurRequest) {
        professeur.setNom(professeurRequest.nom());
        professeur.setCode(professeurRequest.code());
    }

}
