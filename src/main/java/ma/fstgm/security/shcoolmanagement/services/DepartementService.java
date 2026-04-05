package ma.fstgm.security.shcoolmanagement.services;

import ma.fstgm.security.shcoolmanagement.dto.request.DepartementRequest;
import ma.fstgm.security.shcoolmanagement.dto.response.DepartementResponse;
import ma.fstgm.security.shcoolmanagement.entities.Departement;
import ma.fstgm.security.shcoolmanagement.exceptions.ResourceNotFoundException;
import ma.fstgm.security.shcoolmanagement.mapper.DepartementMapper;
import ma.fstgm.security.shcoolmanagement.repositories.DepartementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartementService {
    private final DepartementRepository departementRepository;
    private final DepartementMapper departementMapper;

    public DepartementService(DepartementRepository departementRepository, DepartementMapper departementMapper) {
        this.departementRepository = departementRepository;
        this.departementMapper = departementMapper;
    }

    public DepartementResponse addDepartement(DepartementRequest departementRequest) {
        Departement departement = departementMapper.toEntity(departementRequest);
        Departement addedDepartement = departementRepository.save(departement);
        return departementMapper.toResponse(addedDepartement);


    }

    public void deleteDepartement(Long id) {
        Departement departement = departementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Departement with id :  " + id + " not found"));
        departementRepository.delete(departement);
    }

    public DepartementResponse updateDeprtement(Long id, DepartementRequest departementRequest) {
        Departement departement = departementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Departement with id :  " + id + " not found"));
        departementMapper.updateDepartement(departement, departementRequest);
        departementRepository.save(departement);
        return departementMapper.toResponse(departement);

    }

    public List<DepartementResponse> getAllDepartements() {
        return departementRepository.findAll()
                .stream()
                .map(departementMapper::toResponse)
                .toList();
    }

    public DepartementResponse getDepartementById(Long id) {
        Departement departement = departementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Departement with id :  " + id + " not found"));
        return departementMapper.toResponse(departement);
    }

}
