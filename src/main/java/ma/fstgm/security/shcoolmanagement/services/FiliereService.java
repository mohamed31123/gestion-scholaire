package ma.fstgm.security.shcoolmanagement.services;


import ma.fstgm.security.shcoolmanagement.dto.request.FiliereRequest;
import ma.fstgm.security.shcoolmanagement.dto.request.StudentRequest;
import ma.fstgm.security.shcoolmanagement.dto.response.FiliereResponse;
import ma.fstgm.security.shcoolmanagement.dto.response.StudentResponse;
import ma.fstgm.security.shcoolmanagement.entities.Filiere;
import ma.fstgm.security.shcoolmanagement.entities.Student;
import ma.fstgm.security.shcoolmanagement.exceptions.ResourceNotFoundException;
import ma.fstgm.security.shcoolmanagement.mapper.FiliereMapper;
import ma.fstgm.security.shcoolmanagement.repositories.FiliereRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiliereService {
    private final FiliereRepository filiereRepository;
    private final FiliereMapper filiereMapper;

    public FiliereService(FiliereRepository filiereRepository ,  FiliereMapper filiereMapper) {
        this.filiereRepository = filiereRepository;
        this.filiereMapper = filiereMapper;
    }
    public FiliereResponse addFiliere(FiliereRequest filiereRequest) {
        Filiere filier = filiereMapper.toEntity(filiereRequest);
        Filiere addedFiliere = filiereRepository.save(filier);
        return filiereMapper.toResponse(addedFiliere);
    }
    public void deleteFiliere(Long id ) {
        Filiere filiere = filiereRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Filiere introuvable avec l'id : " + id));
    }
    public List<FiliereResponse> getAllFilieres() {
        return filiereRepository.findAll()
                .stream()
                .map(filiereMapper::toResponse)
                .toList();
    }
    public StudentResponse updateStudent(Long id, StudentRequest dto) {
        Filiere filiere =  filiereRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Étudiant introuvable avec l'id : " + id));
        Filiere updateFiliere = filiereRepository.save(filiere);
        return filiereMapper.toResponse(updateFiliere);

    }
}
