package ma.fstgm.security.shcoolmanagement.repositories;

import ma.fstgm.security.shcoolmanagement.entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.JpqlQueryBuilder;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface DepartementRepository extends JpaRepository<Departement , Long> {

    Optional<Departement> findByNom(String nom);


    @Query("SELECT d FROM Departement d LEFT JOIN FETCH d.professeurs WHERE d.id = :id")
    Departement findWithProfesseurs(@Param("id") Long id);
}
