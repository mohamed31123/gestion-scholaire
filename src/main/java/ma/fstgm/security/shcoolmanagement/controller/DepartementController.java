package ma.fstgm.security.shcoolmanagement.controller;


import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import ma.fstgm.security.shcoolmanagement.dto.request.DepartementRequest;
import ma.fstgm.security.shcoolmanagement.dto.request.SemestreRequest;
import ma.fstgm.security.shcoolmanagement.dto.response.DepartementResponse;
import ma.fstgm.security.shcoolmanagement.dto.response.SemestreResponse;
import ma.fstgm.security.shcoolmanagement.entities.Departement;
import ma.fstgm.security.shcoolmanagement.services.DepartementService;
import ma.fstgm.security.shcoolmanagement.services.SemestreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping
public class DepartementController {


    private final DepartementService departementService;

    public DepartementController(DepartementService departementService) {
        this.departementService = departementService;
    }

    @GetMapping
    @Operation(summary = "recuperer toutes les departements")
    public List<DepartementResponse> getAllDepartements() {
        return departementService.getAllDepartements();
    }

    @GetMapping
    @Operation(summary = "recuperer une departement par son id ")
    public DepartementResponse getDepartementById(@RequestParam("id") Long id) {

        return departementService.getDepartementById(id);
    }

    @PostMapping
    @Operation(summary = "inserer une Departement")
    public DepartementResponse insertDepartement(@RequestBody DepartementRequest dto) {
        return departementService.addDepartement(dto);
    }
    @DeleteMapping
    @Operation(summary = "supprimer une departement")
    public void deleteDepartement( @PathVariable Long id) {
        departementService.deleteDepartement(id);
    }


    @PostMapping
    @Operation(summary = "modifier une departement")
    public DepartementResponse updateDepartement(@Valid @RequestBody DepartementRequest dto , @RequestParam("id") Long id) {
        return departementService.updateDeprtement(id, dto);
    }

}
