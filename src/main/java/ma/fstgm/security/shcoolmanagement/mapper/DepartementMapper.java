package ma.fstgm.security.shcoolmanagement.mapper;

import ma.fstgm.security.shcoolmanagement.dto.request.DepartementRequest;
import ma.fstgm.security.shcoolmanagement.dto.response.DepartementResponse;
import ma.fstgm.security.shcoolmanagement.entities.Departement;
import org.springframework.stereotype.Component;

@Component
public class DepartementMapper {
    public Departement toEntity(DepartementRequest dto) {
        Departement departement = new Departement();
        departement.setNom(dto.nom());
        return departement;

    }

    public DepartementResponse toResponse(Departement departement) {
        return new DepartementResponse(
                departement.getId(),
                departement.getNom()
        );
    }

    public void updateDepartement(Departement departement, DepartementRequest dto) {
        departement.setNom(dto.nom());
    }


}