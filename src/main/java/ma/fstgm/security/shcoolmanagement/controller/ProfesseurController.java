package ma.fstgm.security.shcoolmanagement.controller;


import io.swagger.v3.oas.annotations.Operation;
import ma.fstgm.security.shcoolmanagement.dto.request.ProfesseurRequest;
import ma.fstgm.security.shcoolmanagement.dto.response.ProfesseurResponse;
import ma.fstgm.security.shcoolmanagement.entities.Course;
import ma.fstgm.security.shcoolmanagement.entities.Departement;
import ma.fstgm.security.shcoolmanagement.entities.Student;
import ma.fstgm.security.shcoolmanagement.services.ProfesseurService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professeur")
public class ProfesseurController {

    private final ProfesseurService professeurService;

    public ProfesseurController(ProfesseurService professeurService) {
        this.professeurService = professeurService;
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProfesseurResponse getProfesseur(@PathVariable Long id) {
        return professeurService.findProfById(id);
    }

    @GetMapping("/getAll")

    @Operation(summary = "retourner toutes les Professeurs ")
    @ResponseStatus(HttpStatus.OK)
    public List<ProfesseurResponse> getAllProfesseurs() {
        return professeurService.getAllProfesseur();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProfesseurResponse addProfesseur(@RequestBody ProfesseurRequest dto) {
        return professeurService.addProfesseur(dto);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "supprimer une Professeur")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProfesseur(@PathVariable Long id) {
        professeurService.deleteProfesseur(id);
    }

    @PutMapping("update/{id}")
    @Operation(summary = "modifier une Professeur")
    @ResponseStatus(HttpStatus.OK)
    public ProfesseurResponse updateProfesseur(@PathVariable Long id, ProfesseurRequest dto) {
        return professeurService.updateProfesseur(id, dto);
    }
}
