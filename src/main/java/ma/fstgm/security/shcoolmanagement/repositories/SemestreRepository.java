package ma.fstgm.security.shcoolmanagement.repositories;

import ma.fstgm.security.shcoolmanagement.entities.Semestre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SemestreRepository extends JpaRepository<Semestre, Long> {

    Optional<Semestre> findByAnnee(Semestre semestre);
    Optional<Semestre> findByNom(Semestre semestre);

}
