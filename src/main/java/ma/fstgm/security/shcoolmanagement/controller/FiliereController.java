package ma.fstgm.security.shcoolmanagement.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import ma.fstgm.security.shcoolmanagement.dto.request.FiliereRequest;
import ma.fstgm.security.shcoolmanagement.dto.response.FiliereResponse;
import ma.fstgm.security.shcoolmanagement.services.FiliereService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filiere")
public class FiliereController {

    private final FiliereService FiliereService;

    public FiliereController(FiliereService FiliereService) {
        this.FiliereService = FiliereService;
    }

    @GetMapping
    @Operation(summary = "recuperer toutes les Filieres")
    public List<FiliereResponse> getAllFilieres() {
        return FiliereService.getAllFilieres();
    }

    @GetMapping("/GET/{id}")
    @Operation(summary = "recuperer une Filiere par son id ")
    public FiliereResponse getFiliereById(@RequestParam("id") Long id) {
        return FiliereService.getFiliereById(id);
    }

    @PostMapping
    @Operation(summary = "inserer une Filiere")
    public FiliereResponse insertFiliere(@RequestBody FiliereRequest dto) {
        return FiliereService.addFiliere(dto);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "supprimer une Filiere")
    public void deleteFiliere(@PathVariable Long id) {
        FiliereService.deleteFiliere(id);
    }


    @PutMapping
    @Operation(summary = "modifier une Filiere")
    public FiliereResponse updateFiliere(@Valid @RequestBody FiliereRequest dto, @RequestParam("id") Long id) {
        return FiliereService.updateFiliere(id, dto);
    }


}
