package ma.fstgm.security.shcoolmanagement.repositories;

import ma.fstgm.security.shcoolmanagement.entities.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface FiliereRepository extends JpaRepository<Filiere, Long> {

    Optional<Filiere> findByNom(String nom);

    Optional<Filiere> findByCode(String code);
}
