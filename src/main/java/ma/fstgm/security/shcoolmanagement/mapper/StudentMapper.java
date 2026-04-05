package ma.fstgm.security.shcoolmanagement.mapper;

import ma.fstgm.security.shcoolmanagement.dto.request.StudentRequest;
import ma.fstgm.security.shcoolmanagement.dto.response.StudentResponse;
import ma.fstgm.security.shcoolmanagement.entities.Filiere;
import ma.fstgm.security.shcoolmanagement.entities.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public Student toEntity(StudentRequest dto , Filiere filiere ){
        Student student = new Student();
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());
        student.setPassword(dto.password());
        student.setAge(dto.age());
        student.setMajor(dto.major());
        student.setFiliere(filiere);
        return student;
    }
    public StudentResponse toResponse(Student student){
       return new StudentResponse(
               student.getId(),
               student.getFirstName(),
               student.getLastName(),
               student.getEmail(),
               student.getMajor(),
               student.getAge() ,
               student.getFiliere().getNom()

       );

    }
    public void updateEntityFromDto(StudentRequest dto , Student student){
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());
        student.setPassword(dto.password());
        student.setAge(dto.age());
        student.setMajor(dto.major());
    }
}
