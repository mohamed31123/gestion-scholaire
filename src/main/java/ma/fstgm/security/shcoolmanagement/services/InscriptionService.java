package ma.fstgm.security.shcoolmanagement.services;


import ma.fstgm.security.shcoolmanagement.dto.request.InscriptionRequest;
import ma.fstgm.security.shcoolmanagement.dto.response.InscriptionResponse;
import ma.fstgm.security.shcoolmanagement.entities.Inscription;
import ma.fstgm.security.shcoolmanagement.exceptions.ResourceNotFoundException;
import ma.fstgm.security.shcoolmanagement.mapper.InscriptionMapper;
import ma.fstgm.security.shcoolmanagement.repositories.InscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscriptionService {
    private InscriptionRepository inscriptionRepository;
    private InscriptionMapper inscriptionMapper;

    public InscriptionService(InscriptionRepository inscriptionRepository, InscriptionMapper inscriptionMapper) {
        this.inscriptionRepository = inscriptionRepository;
        this.inscriptionMapper = inscriptionMapper;
    }

    public InscriptionResponse createInscription(InscriptionRequest inscriptionRequest) {
        Inscription inscription = inscriptionMapper.toEntity(inscriptionRequest);
        Inscription inscriptionSaved = inscriptionRepository.save(inscription);
        return inscriptionMapper.toResponse(inscriptionSaved);
    }

    public List<InscriptionResponse> getAllInscriptions() {
        return inscriptionRepository.findAll()
                .stream()
                .map(inscriptionMapper::toResponse)
                .toList();

    }

    public void deleteInscription(Long id) {
        Inscription inscription = inscriptionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Inscription introuvable avec le id : " + id));
        inscriptionRepository.delete(inscription);
    }

    public InscriptionResponse updateInscription(Long id, InscriptionRequest dto) {
        Inscription inscription = inscriptionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Inscription introuvable avec le id : " + id));

        inscriptionMapper.UpdateInscription(inscription, dto);

        inscriptionRepository.save(inscription);

        return inscriptionMapper.toResponse(inscription);

    }
}
