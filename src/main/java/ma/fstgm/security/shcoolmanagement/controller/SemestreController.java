package ma.fstgm.security.shcoolmanagement.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import ma.fstgm.security.shcoolmanagement.dto.request.SemestreRequest;
import ma.fstgm.security.shcoolmanagement.dto.response.SemestreResponse;
import ma.fstgm.security.shcoolmanagement.entities.Semestre;
import ma.fstgm.security.shcoolmanagement.services.SemestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/semestre")
public class SemestreController {

    private final SemestreService semestreService;

    public SemestreController(SemestreService semestreService) {
        this.semestreService = semestreService;
    }

    @GetMapping("/getAll")
    @Operation(summary = "recuperer toutes les semestres")
    public List<SemestreResponse> getAllSemestre() {
        return semestreService.getAllSemestre();
    }

    @GetMapping("get/{id}")
    @Operation(summary = "recuperer une semestre par son id ")
    public SemestreResponse getSemestreById(@RequestParam("id") Long id) {
        return semestreService.getSemestreById(id);
    }

    @PostMapping
    @Operation(summary = "inserer une Semestre")
    public SemestreResponse insertSemestre(@RequestBody SemestreRequest dto) {
        return semestreService.addSemestre(dto);
    }

    @DeleteMapping("delete/{id}")
    @Operation(summary = "supprimer une semestre")
    public void deleteSemestre(@PathVariable Long id) {
        semestreService.deleteSemestre(id);
    }



    @PutMapping("update/{id}")
    public SemestreResponse updateSemestre(@PathVariable  Long id, @Valid @RequestBody SemestreRequest dto) {
        return semestreService.updateSemestre(dto, id);
    }


}
