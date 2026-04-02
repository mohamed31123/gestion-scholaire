package ma.fstgm.security.shcoolmanagement.repositories;

import ma.fstgm.security.shcoolmanagement.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findByCode(Course course);
    @Query("SELECT c FROM Course c LEFT JOIN FETCH c.professeur WHERE c.id = : id ")
    Course FindCourseByProf(@Param("id")  Long id) ;
}
