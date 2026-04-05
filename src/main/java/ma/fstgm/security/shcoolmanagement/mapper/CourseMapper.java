package ma.fstgm.security.shcoolmanagement.mapper;

import ma.fstgm.security.shcoolmanagement.dto.request.CourseRequest;
import ma.fstgm.security.shcoolmanagement.dto.response.CourseResponse;
import ma.fstgm.security.shcoolmanagement.entities.Course;
import ma.fstgm.security.shcoolmanagement.entities.Professeur;
import org.springframework.stereotype.Component;


@Component
public class CourseMapper {
    public Course toEntity(CourseRequest dto , Professeur prof){
        Course course = new Course();
        course.setCode(dto.code());
        course.setProfesseur(prof);
        course.setProfesseur(prof);
        course.setNomCours(dto.nomCours());
        return course ;
    }
    public CourseResponse toResponse(Course course ){

        return new CourseResponse(
                course.getId() ,
                course.getNomCours(),
                course.getCode(),
                course.getProfesseur().getNom()


        );
    }
    public void updateCourse(Course course , CourseRequest courseRequest){
        course.setCode(courseRequest.code());
        course.setNomCours(courseRequest.nomCours());
    }

}
