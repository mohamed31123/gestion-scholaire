package ma.fstgm.security.shcoolmanagement.repositories;

import ma.fstgm.security.shcoolmanagement.entities.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FiliereRepository extends JpaRepository<Filiere, Long> {
    Optional<Filiere> findByNom(Filiere filiere);
    Optional<Filiere> findByCode(Filiere filiere);
}
