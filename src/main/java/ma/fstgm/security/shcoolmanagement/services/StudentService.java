package ma.fstgm.security.shcoolmanagement.services;

import ma.fstgm.security.shcoolmanagement.dto.request.StudentRequest;
import ma.fstgm.security.shcoolmanagement.dto.response.StudentResponse;
import ma.fstgm.security.shcoolmanagement.entities.Student;
import ma.fstgm.security.shcoolmanagement.exceptions.ResourceNotFoundException;
import ma.fstgm.security.shcoolmanagement.mapper.StudentMapper;
import ma.fstgm.security.shcoolmanagement.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public StudentResponse addStudent(StudentRequest studentRequest) {
        Student student = studentMapper.toEntity(studentRequest);
        Student addStudent = studentRepository.save(student);
        return studentMapper.toResponse(addStudent);

    }

    public List<StudentResponse> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toResponse)
                .toList();
    }

    public StudentResponse getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Étudiant introuvable avec l'id : " + id));

        return studentMapper.toResponse(student);
    }

    public StudentResponse updateStudent(Long id, StudentRequest dto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Étudiant introuvable avec l'id : " + id));
        studentMapper.updateEntityFromDto(dto, student);
        Student updateStudent = studentRepository.save(student);
        return studentMapper.toResponse(updateStudent);

    }
    public void deleteStudent(Long id ){
        Student student  = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Étudiant introuvable avec l'id : " + id));
        studentRepository.delete(student);
    }


}
