package ma.fstgm.security.shcoolmanagement.mapper;

import ma.fstgm.security.shcoolmanagement.dto.request.SemestreRequest;
import ma.fstgm.security.shcoolmanagement.dto.response.SemestreResponse;
import ma.fstgm.security.shcoolmanagement.entities.Semestre;

public class SemestreMapper {

    public Semestre toEntity(SemestreRequest dto){
        Semestre semestre = new Semestre();
        semestre.setNom(dto.nom());
        semestre.setAnnee(dto.annee());

        return semestre;
    }

    public SemestreResponse toResponse(Semestre semestre){
        return new SemestreResponse(
                semestre.getId(),
                semestre.getAnnee(),
                semestre.getNom()
        );
    }

    public void updateSemestre(Semestre semestre , SemestreRequest semestreRequest){
        semestre.setAnnee(semestreRequest.annee());
        semestre.setNom(semestreRequest.nom());
    }
}
