package ma.fstgm.security.shcoolmanagement.services;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {
    private final String secretkey = "Mohamed123Masecret@mohamdeddinari";
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+864000000))
                .signWith(SignatureAlgorithm.HS256,secretkey)
                .compact();
    }
}
