package ua.nure.tur.testapi.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import ua.nure.tur.testapi.entities.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

import static java.util.Collections.emptyList;

public class TokenAuthenticationService {

    static private final long EXPIRATION_TIME = 864_000_000;
    static private final String SECRET = "ThisIsASecret";
    static private final String TOKEN_PREFIX = "Bearer";
    static private final String HEADER_STRING = "Authorization";

    public static String getToken(User user) {
        String JWT = Jwts.builder()
                .setSubject(Integer.toString(user.getId()))
                .setAudience(user.getRole())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        return TOKEN_PREFIX + ' ' + JWT;
    }

    static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            String id = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();
            String role = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .getAudience();
            return id != null && role != null ?
                    new UsernamePasswordAuthenticationToken(id, role, emptyList()) :
                    null;
        }
        return null;
    }
}
