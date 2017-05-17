package ua.nure.tur.testapi.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.emptyList;

public class TokenAuthenticationService {

    static private final long EXPIRATION_TIME = 864_000_000;
    static private final String SECRET = "ThisIsASecret";
    static private final String TOKEN_PREFIX = "Bearer";
    static private final String HEADER_STRING = "Authorization";

    static void addAuthentication(HttpServletResponse res, int id, String role) {
        Map<String, Object> claims = new HashMap<>();
        String JWT = Jwts.builder()
                .setSubject(Integer.toString(id))
                .setAudience(role)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();

        try {
            OutputStream outputStream = res.getOutputStream();
            outputStream.write((TOKEN_PREFIX + ' ' + JWT).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
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
