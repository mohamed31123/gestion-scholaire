package ma.fstgm.security.shcoolmanagement.controller;


import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import ma.fstgm.security.shcoolmanagement.dto.request.CourseRequest;
import ma.fstgm.security.shcoolmanagement.dto.response.CourseResponse;
import ma.fstgm.security.shcoolmanagement.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    @Operation(summary = "Adding a course")
    @ResponseStatus(HttpStatus.CREATED)
    public CourseResponse addCourse(@Valid @RequestBody CourseRequest request) {
        return courseService.addCourse(request);
    }


    @GetMapping
    public List<CourseResponse> getCourses() {
        return courseService.listAllCours();
    }


    @GetMapping("/{id}")
    @Operation(summary = "getting a course by id")
    public CourseResponse getCourse(@PathVariable Long id) {

        return courseService.getCourseById(id);
    }



    @DeleteMapping("/delete/{id}")
    @Operation(summary = "deleting a course")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }


}
