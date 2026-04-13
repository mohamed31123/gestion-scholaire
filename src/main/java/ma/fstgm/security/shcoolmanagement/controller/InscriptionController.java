package ma.fstgm.security.shcoolmanagement.controller;


import io.swagger.v3.oas.annotations.Operation;
import ma.fstgm.security.shcoolmanagement.dto.request.InscriptionRequest;
import ma.fstgm.security.shcoolmanagement.dto.response.InscriptionResponse;
import ma.fstgm.security.shcoolmanagement.entities.Course;
import ma.fstgm.security.shcoolmanagement.entities.Inscription;
import ma.fstgm.security.shcoolmanagement.entities.InscriptionPK;
import ma.fstgm.security.shcoolmanagement.entities.Student;
import ma.fstgm.security.shcoolmanagement.services.InscriptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscription")
public class InscriptionController {

    private final InscriptionService inscriptionService;

    public InscriptionController(InscriptionService inscriptionService) {
        this.inscriptionService = inscriptionService;
    }

    @GetMapping("/get/{id}")
    public InscriptionResponse getInscription(@PathVariable InscriptionPK id) {
        return inscriptionService.getInscriptionById(id);
    }

    @GetMapping("/getAll")
    @Operation(summary = "retourner toutes les inscriptions ")
    public List<InscriptionResponse> getAllInscriptions() {
        return inscriptionService.getAllInscriptions();
    }

    @PostMapping
    @Operation(summary = "ajouter un inscription")
    public InscriptionResponse addInscription(@RequestBody InscriptionRequest dto, Course course, Student student) {
        return inscriptionService.createInscription(dto, course, student);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "supprimer une inscription")
    public void deleteInscription(@PathVariable InscriptionPK id) {
        inscriptionService.deleteInscription(id);
    }

    @PutMapping("update/{id}")
    @Operation(summary = "modifier une inscription")
    public InscriptionResponse updateInscription(@PathVariable InscriptionPK id, InscriptionRequest dto) {
        return inscriptionService.updateInscription(id, dto);
    }

}
