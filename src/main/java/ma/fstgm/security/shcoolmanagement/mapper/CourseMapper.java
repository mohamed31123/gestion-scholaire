package ma.fstgm.security.shcoolmanagement.mapper;

import ma.fstgm.security.shcoolmanagement.dto.request.CourseRequest;
import ma.fstgm.security.shcoolmanagement.dto.response.CourseResponse;
import ma.fstgm.security.shcoolmanagement.entities.Course;
import org.springframework.stereotype.Component;


@Component
public class CourseMapper {
    public Course toEntity(CourseRequest dto){
        Course course = new Course();
        course.setCode(dto.code());
        return course ;
    }
    public CourseResponse toResponse(Course course ){

        return new CourseResponse(
                course.getId() ,
                course.getNomCours(),
                course.getCode()

        );
    }
    public void updateCourse(Course course , CourseRequest courseRequest){
        course.setCode(courseRequest.code());
        course.setNomCours(courseRequest.nomCours());
    }

}
