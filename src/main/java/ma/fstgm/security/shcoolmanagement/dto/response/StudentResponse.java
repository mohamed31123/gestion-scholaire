package ma.fstgm.security.shcoolmanagement.dto.response;



public record StudentResponse (
     Long id ,
     String firstName,
     String lastName,
     String email,
     String majour ,
     Integer age ,
     String filiere

){}


