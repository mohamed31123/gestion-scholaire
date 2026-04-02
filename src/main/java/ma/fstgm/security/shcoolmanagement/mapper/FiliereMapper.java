package ma.fstgm.security.shcoolmanagement.mapper;

import ma.fstgm.security.shcoolmanagement.dto.request.FiliereRequest;
import ma.fstgm.security.shcoolmanagement.dto.response.FiliereResponse;
import ma.fstgm.security.shcoolmanagement.entities.Filiere;
import org.springframework.stereotype.Component;

@Component
public class FiliereMapper {
    public Filiere toEntity(FiliereRequest filiereRequest) {

        Filiere filiere = new Filiere();
        filiere.setCode(filiereRequest.code());
        filiere.setNom(filiereRequest.name());
        return filiere;


    }
    public FiliereResponse toResponse(Filiere filiere) {
        return new FiliereResponse(
            filiere.getId() ,
            filiere.getCode() ,
            filiere.getNom()

        );


    }
    public void updateFiliere(Filiere filiere , FiliereRequest filiereRequest) {
        filiere.setNom(filiereRequest.name());
        filiere.setCode(filiereRequest.code());
    }

}
