package ma.fstgm.security.shcoolmanagement.services;


import ma.fstgm.security.shcoolmanagement.dto.request.CourseRequest;
import ma.fstgm.security.shcoolmanagement.dto.response.CourseResponse;
import ma.fstgm.security.shcoolmanagement.entities.Course;
import ma.fstgm.security.shcoolmanagement.entities.Professeur;
import ma.fstgm.security.shcoolmanagement.exceptions.ResourceNotFoundException;
import ma.fstgm.security.shcoolmanagement.mapper.CourseMapper;
import ma.fstgm.security.shcoolmanagement.mapper.FiliereMapper;
import ma.fstgm.security.shcoolmanagement.repositories.CourseRepository;
import ma.fstgm.security.shcoolmanagement.repositories.FiliereRepository;
import ma.fstgm.security.shcoolmanagement.repositories.ProfesseurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final FiliereRepository filiereRepository;
    private final FiliereMapper filiereMapper;
    private final ProfesseurRepository professeurRepository;

    public CourseService(CourseRepository courseRepository, CourseMapper courseMapper, FiliereRepository filiereRepository, FiliereMapper filiereMapper, ProfesseurRepository professeurRepository) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
        this.filiereRepository = filiereRepository;
        this.filiereMapper = filiereMapper;
        this.professeurRepository = professeurRepository;

    }

    public CourseResponse addCourse(CourseRequest request) {

        Professeur prof = professeurRepository.findById(request.idProf())
                .orElseThrow(() -> new ResourceNotFoundException("Professeur introuvable avec id " + request.idProf()));

        Course course = courseMapper.toEntity(request, prof);
        Course addCourse = courseRepository.save(course);
        return courseMapper.toResponse(addCourse);
    }

    public void deleteCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course no trouvable avec l'id  " + id));
        courseRepository.delete(course);
    }

    public List<CourseResponse> listAllCours() {
        return courseRepository.findAll()
                .stream()
                .map(courseMapper::toResponse)
                .toList();
    }

    public CourseResponse updateCours(Long id, CourseRequest dto) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Étudiant introuvable avec l'id : " + id));
        courseMapper.updateCourse(course, dto);
        Course updateCourse = courseRepository.save(course);
        return courseMapper.toResponse(updateCourse);

    }

    public CourseResponse getCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course no trouvable avec l'id  " + id));
        return courseMapper.toResponse(course);
    }

}
