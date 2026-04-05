package ma.fstgm.security.shcoolmanagement.mapper;

import ma.fstgm.security.shcoolmanagement.dto.request.InscriptionRequest;
import ma.fstgm.security.shcoolmanagement.dto.response.InscriptionResponse;
import ma.fstgm.security.shcoolmanagement.entities.Course;
import ma.fstgm.security.shcoolmanagement.entities.Inscription;
import ma.fstgm.security.shcoolmanagement.entities.InscriptionPK;
import ma.fstgm.security.shcoolmanagement.entities.Student;
import org.springframework.stereotype.Component;


@Component
public class InscriptionMapper {
    public Inscription toEntity(InscriptionRequest dto , Course course , Student student){
        Inscription inscription = new Inscription();
        inscription.setId(new InscriptionPK(course.getId(), student.getId()));
        inscription.setStudent(student);
        inscription.setCourse (course);
        inscription.setDateInscription(dto.dateInscription());
        return inscription ;
    }

    public InscriptionResponse toResponse(Inscription inscription){
        return new InscriptionResponse(
                inscription.getStudent().getId(),
                inscription.getCourse().getId(),
                inscription.getDateInscription(),
                inscription.getCourse().getNomCours(),
                inscription.getStudent().getFirstName(),
                inscription.getStudent().getLastName()
        );
    }
    public void updateInscription(Inscription inscription , InscriptionRequest inscriptionRequest){

        inscription.setDateInscription(inscriptionRequest.dateInscription());
    }
}
