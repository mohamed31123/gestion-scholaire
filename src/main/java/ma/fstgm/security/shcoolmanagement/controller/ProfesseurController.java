package ma.fstgm.security.shcoolmanagement.controller;


import io.swagger.v3.oas.annotations.Operation;
import ma.fstgm.security.shcoolmanagement.dto.request.ProfesseurRequest;
import ma.fstgm.security.shcoolmanagement.dto.response.ProfesseurResponse;
import ma.fstgm.security.shcoolmanagement.entities.Course;
import ma.fstgm.security.shcoolmanagement.entities.Departement;
import ma.fstgm.security.shcoolmanagement.entities.Student;
import ma.fstgm.security.shcoolmanagement.services.ProfesseurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfesseurController {

    private final ProfesseurService ProfesseurService;

    public ProfesseurController(ProfesseurService ProfesseurService) {
        this.ProfesseurService = ProfesseurService;
    }

    @GetMapping("/get/{id}")
    public ProfesseurResponse getProfesseur(@PathVariable Long id) {
        return ProfesseurService.findProfById(id);
    }

    @GetMapping("/getAll")
    @Operation(summary = "retourner toutes les Professeurs ")
    public List<ProfesseurResponse> getAllProfesseurs() {
        return ProfesseurService.getAllProfesseur();
    }

    @PostMapping
    @Operation(summary = "ajouter un Professeur")
    public ProfesseurResponse addProfesseur(@RequestBody ProfesseurRequest dto, Departement departement) {
        return ProfesseurService.addProfesseur(dto,  departement);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "supprimer une Professeur")
    public void deleteProfesseur(@PathVariable Long id) {
        ProfesseurService.deleteProfesseur(id);
    }

    @PutMapping("update/{id}")
    @Operation(summary = "modifier une Professeur")
    public ProfesseurResponse updateProfesseur(@PathVariable Long id, ProfesseurRequest dto) {
        return ProfesseurService.updateProfesseur(id , dto);
    }
}
