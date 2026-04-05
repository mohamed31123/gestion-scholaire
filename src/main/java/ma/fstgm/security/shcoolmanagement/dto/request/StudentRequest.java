package ma.fstgm.security.shcoolmanagement.dto.request;


import jakarta.validation.constraints.*;
import ma.fstgm.security.shcoolmanagement.entities.Filiere;

public record StudentRequest(
        @NotBlank(message = "The first name cannot be Blank")
        String firstName,
        @NotBlank(message = "The last name cannot be Blank")
        String lastName,


        @NotBlank(message = "The major name cannot be Blank")
        String major,

        @Email(message = "Your have submitted an invalid email")
        @NotBlank(message = "Email cannot be Blank")
        String email,
        @Size(min = 8, message = "Password should contain at least 8 characters")
        String password,
        @NotNull(message = "age cannot be null")
        @Min(value = 17, message = "The Minumum age is 17")
        @Max(value = 40, message = "the Max age is 40")
        Integer age,
        Long id_filiere
) {
}
