package ma.fstgm.security.shcoolmanagement.dto.request;

import lombok.Getter;
import lombok.Setter;

//un date transfer obkect qui contient les informations qui doit etre entre par un utilisateur afin de l'idnetifer
@Getter @Setter
public class LoginRequest {

    private String username;
    private String password;
}
