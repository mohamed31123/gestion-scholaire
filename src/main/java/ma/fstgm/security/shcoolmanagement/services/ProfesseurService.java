package ma.fstgm.security.shcoolmanagement.services;


import ma.fstgm.security.shcoolmanagement.dto.request.ProfesseurRequest;
import ma.fstgm.security.shcoolmanagement.dto.response.ProfesseurResponse;
import ma.fstgm.security.shcoolmanagement.entities.Departement;
import ma.fstgm.security.shcoolmanagement.entities.Professeur;
import ma.fstgm.security.shcoolmanagement.exceptions.ResourceNotFoundException;
import ma.fstgm.security.shcoolmanagement.mapper.ProfesseurMapper;
import ma.fstgm.security.shcoolmanagement.repositories.DepartementRepository;
import ma.fstgm.security.shcoolmanagement.repositories.ProfesseurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesseurService {

    private final ProfesseurRepository professeurRepository;
    private final ProfesseurMapper professeurMapper;
    private final DepartementRepository departementRepository;

   public ProfesseurService(ProfesseurRepository professeurRepository , ProfesseurMapper professeurMapper , DepartementRepository departementRepository) {
       this.professeurRepository = professeurRepository  ;
       this.professeurMapper = professeurMapper;
       this.departementRepository = departementRepository;
   }

   public ProfesseurResponse addProfesseur(ProfesseurRequest dto) {
       Departement departement = departementRepository.findById(dto.idDepartement())
               .orElseThrow(() -> new ResourceNotFoundException("Departement not found"));
       Professeur prof  = professeurMapper.toEntity(dto , departement);
       Professeur saved = professeurRepository.save(prof);
       return professeurMapper.toResponse(saved);
   }

   public void deleteProfesseur(Long id ){
       Professeur prof = professeurRepository.findById(id)
               .orElseThrow(()->new ResourceNotFoundException("Professeur introuvable avec le id : " + id));
       professeurRepository.delete(prof);
   }
   public List<ProfesseurResponse> getAllProfesseur(){
       return professeurRepository.findAll()
               .stream()
               .map(professeurMapper::toResponse)
               .toList();
   }

   public ProfesseurResponse updateProfesseur(Long id ,  ProfesseurRequest professeurRequest){
       Professeur professeur = professeurRepository.findById(id)
               .orElseThrow(()->new ResourceNotFoundException("Professeur introuvable avec le id : " + id));
       professeurMapper.updateProfesseur(professeur, professeurRequest);
       Professeur profSaved = professeurRepository.save(professeur);
       return professeurMapper.toResponse(profSaved);


   }

    public ProfesseurResponse findProfById(Long id){
        Professeur prof = professeurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professeur introuvable"));
        return professeurMapper.toResponse(prof);
    }
}
