package ma.fstgm.security.shcoolmanagement.dto.request;


import lombok.Data;

@Data
public class CourseWithProfRequest {
    private CourseRequest course;
    private Long professeurId;
}
