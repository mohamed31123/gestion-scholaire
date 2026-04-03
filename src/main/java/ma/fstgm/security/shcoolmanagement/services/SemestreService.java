package ma.fstgm.security.shcoolmanagement.services;


import ma.fstgm.security.shcoolmanagement.dto.request.SemestreRequest;
import ma.fstgm.security.shcoolmanagement.dto.response.SemestreResponse;
import ma.fstgm.security.shcoolmanagement.entities.Semestre;
import ma.fstgm.security.shcoolmanagement.exceptions.ResourceNotFoundException;
import ma.fstgm.security.shcoolmanagement.mapper.SemestreMapper;
import ma.fstgm.security.shcoolmanagement.repositories.SemestreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemestreService {
    private final SemestreRepository semestreRepository;
    private final SemestreMapper semestreMapper;

    public SemestreService(SemestreRepository semestreRepository, SemestreMapper semestreMapper) {
        this.semestreRepository = semestreRepository;
        this.semestreMapper = semestreMapper;
    }

    public SemestreResponse addSemestre(SemestreRequest semestreRequest) {
        Semestre semestre = semestreMapper.toEntity(semestreRequest);
        Semestre savedSemestre = semestreRepository.save(semestre);
        return semestreMapper.toResponse(savedSemestre);
    }

    public SemestreResponse updateSemestre(SemestreRequest semestreRequest , Long id ) {
        Semestre semestre = semestreRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Semestre Not found with id: " + id));
        semestreMapper.updateSemestre(semestre , semestreRequest);
        Semestre savedSemestre = semestreRepository.save(semestre);
        return semestreMapper.toResponse(savedSemestre);
    }

    public void deleteSemestre(Long id) {
        Semestre semestre = semestreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Semestre Not found with id: " + id));
        semestreRepository.delete(semestre);
    }

    public List<SemestreResponse> getAllSemestre() {
        return semestreRepository.findAll()
                .stream()
                .map(semestreMapper::toResponse)
                .toList();

    }
    public SemestreResponse getSemestreById(Long id) {
        Semestre semestre = semestreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Semestre Not found with id: " + id));
        return semestreMapper.toResponse(semestre);
    }
}
