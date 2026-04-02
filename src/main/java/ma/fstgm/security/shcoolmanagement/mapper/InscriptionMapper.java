package ma.fstgm.security.shcoolmanagement.mapper;

import ma.fstgm.security.shcoolmanagement.dto.request.InscriptionRequest;
import ma.fstgm.security.shcoolmanagement.dto.response.InscriptionResponse;
import ma.fstgm.security.shcoolmanagement.entities.Inscription;

public class InscriptionMapper {
    public Inscription toEntity(InscriptionRequest dto){
        Inscription inscription = new Inscription();
        inscription.setDateInscription(dto.dateInscription());
        return inscription ;
    }
    public InscriptionResponse toResponse(Inscription inscription){
        return new InscriptionResponse(
                inscription.getId(),
                inscription.getDateInscription()
        );
    }
    public void UpdateInscription(Inscription inscription , InscriptionRequest inscriptionRequest){

        inscription.setDateInscription(inscriptionRequest.dateInscription());
    }
}
