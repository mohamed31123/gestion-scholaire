package ma.fstgm.security.shcoolmanagement.repositories;

import ma.fstgm.security.shcoolmanagement.entities.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfesseurRepository extends JpaRepository<Professeur , Long> {
    Optional<Professeur> findByNom(Professeur professeur);
}
