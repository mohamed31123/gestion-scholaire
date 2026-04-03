package ma.fstgm.security.shcoolmanagement.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import ma.fstgm.security.shcoolmanagement.dto.request.StudentRequest;
import ma.fstgm.security.shcoolmanagement.dto.response.StudentResponse;

import ma.fstgm.security.shcoolmanagement.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    @Operation(summary = "Adding a student")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResponse addStudent(@Valid @RequestBody StudentRequest dto) {
        return studentService.addStudent(dto);
    }

    @GetMapping
    public List<StudentResponse> getStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/get/{id}")
    @Operation(summary = "getting a student by id")
    public StudentResponse getStudent(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/update/{id}")
    @Operation(summary = "Updating a student")
    public StudentResponse updateStudent(@PathVariable Long id, @Valid @RequestBody StudentRequest dto) {
        return studentService.updateStudent(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Deleting  a student")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

}
